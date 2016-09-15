package ru.sbt.etsm.drdiff.comparator.logger.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sbt-morozov-kv on 09.08.2016.
 */
public class ChangeTree {

    private static Set<String> errors = new HashSet<>();

    private ChangeItem root;

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

        for (ChangeItem leave : leaves)
            result.add(leave.getVector());

        return result;
    }

    public List<ChangeVector> getFlatVectors() {
        return (new ChangeVector(root)).split();
    }

    public ChangeTree reverseTree() {
        ChangeTree reverseTree = new ChangeTree(new ChangeItem(new Descriptor("Changes")));
        root.setParent(null);

        List<ChangeVector> vectors = getBaseVectors();

        for (ChangeVector vector : vectors)
            reverseTree.addVector(vector);

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
