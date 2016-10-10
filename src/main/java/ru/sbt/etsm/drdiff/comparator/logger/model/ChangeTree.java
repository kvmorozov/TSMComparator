package ru.sbt.etsm.drdiff.comparator.logger.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by sbt-morozov-kv on 09.08.2016.
 */
public class ChangeTree {

    private static final Set<String> errors = new HashSet<>();

    private final ChangeItem root;

    public ChangeTree(ChangeItem root) {
        this.root = root;
    }

    public static void registerError(String error) {
        errors.add(error);
    }

    public List<ChangeVector> getBaseVectors() {
        List<ChangeVector> result = new ArrayList<>();
        Set<ChangeItem> leaves = new HashSet<>();
        root.collectLeaves(leaves);

        result.addAll(leaves.stream().map(ChangeItem::getVector).collect(Collectors.toList()));

        return result;
    }

    public List<ChangeVector> getFlatVectors() {
        return (new ChangeVector(root)).split();
    }

    public ChangeTree reverseTree() {
        ChangeTree reverseTree = new ChangeTree(new ChangeItem(Descriptor.CHANGES));
        root.setParent(null);

        List<ChangeVector> vectors = getBaseVectors();

        vectors.forEach(reverseTree::addVector);

        return reverseTree;
    }

    void addVector(ChangeVector vector) {
        root.addVector(vector);
    }

    public static Set<String> getErrors() {
        return errors;
    }

    public ChangeItem getRoot() {
        return root;
    }
}
