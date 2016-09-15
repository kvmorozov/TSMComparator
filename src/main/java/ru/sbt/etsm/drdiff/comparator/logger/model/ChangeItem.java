package ru.sbt.etsm.drdiff.comparator.logger.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.sbt.etsm.drdiff.comparator.serializers.TsmSerializerBase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import static ru.sbt.etsm.drdiff.comparator.logger.file.TsmFileLogger.*;

/**
 * Created by sbt-morozov-kv on 09.08.2016.
 */
public class ChangeItem {

    private static final String STR_SPACE = " ";
    public static final String EMPTY_STR = "";

    private Set<ChangeItem> parents;
    private String text;

    public static final ChangeItem NULL_CHANGE = new ChangeItem();

    public enum ChangeItemType {
        ADD("added"),
        REMOVE("removed"),
        CHANGE("changed");

        String desc;

        ChangeItemType(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }

    private Descriptor descObject;
    private List<ChangeItem> childItems = new CopyOnWriteArrayList<>();
    private ChangeItemType changeItemType;
    private String oldObjDesc, newObjDesc;

    private ChangeItem() {
    }

    ChangeItem(String text) {
        this.text = text;
    }

    ChangeItem(Descriptor descObject) {
        this.descObject = descObject;
    }

    public ChangeItem(Descriptor descObject, Object oldValue, Object newValue) {
        this.descObject = descObject;

        if (oldValue == null)
            setChangeItemType(ChangeItemType.ADD);
        else if (newValue == null)
            setChangeItemType(ChangeItemType.REMOVE);
        else
            setChangeItemType(ChangeItemType.CHANGE);

        oldObjDesc = serializeObj(oldValue);
        newObjDesc = serializeObj(newValue);
    }

    public void addChild(ChangeItem item) {
        if (item != null)
            childItems.add(item);
    }

    public int getChildCount() {
        return childItems.size();
    }

    public ChangeItem setChangeItemType(ChangeItemType changeItemType) {
        this.changeItemType = changeItemType;

        return this;
    }

    public ChangeItem setDescObject(Descriptor descObject) {
        this.descObject = descObject;

        return this;
    }

    public ChangeItemType getChangeItemType() {
        return changeItemType == null ? ChangeItemType.CHANGE : changeItemType;
    }

    public String getText() {
        if (text == null)
            try {
                text = PLACEHOLDER_TABS_N +
                        descObject.toString() +
                        STR_SPACE +
                        getChangeItemType().getDesc() +
                        ":" + STR_SPACE +
                        (getChildCount() == 0 && getChangeItemType() == ChangeItemType.CHANGE ?
                                ("\n" + PLACEHOLDER_TABS_N1 + "Old value:\n" + PLACEHOLDER_TABS_N2) +
                                        oldObjDesc +
                                        "\n" + PLACEHOLDER_TABS_N1 + "New value:\n" + PLACEHOLDER_TABS_N2 +
                                        newObjDesc : EMPTY_STR) +
                        getDescIfTrue(getChangeItemType() == ChangeItemType.ADD, newObjDesc) +
                        getDescIfTrue(getChangeItemType() == ChangeItemType.REMOVE, oldObjDesc) +
                        System.getProperty("line.separator");
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        return text;
    }

    private String getDescIfTrue(boolean condition, String objDesc) throws JsonProcessingException {
        return condition ? objDesc : EMPTY_STR;
    }

    private String serializeObj(Object obj) {
        return TsmSerializerBase.getSerializer(obj).serialize(obj);
    }

    public List<ChangeItem> getChildItems() {
        return childItems;
    }

    void setParent(ChangeItem parent) {
        if (parents == null)
            parents = new HashSet<>();

        if (parent != null)
            parents.add(parent);

        if (getChildItems().size() > 0)
            for (ChangeItem child : getChildItems())
                child.setParent(this);
    }

    void collectLeaves(Set<ChangeItem> leaves) {
        if (getChildItems().size() > 0)
            for (ChangeItem child : getChildItems())
                child.collectLeaves(leaves);
        else
            leaves.add(this);
    }

    ChangeVector getVector() {
        ChangeVector vector = new ChangeVector();
        collectVector(vector);

        return vector;
    }

    private ChangeItem collectVector(ChangeVector vector) {
        ChangeItem newItem = new ChangeItem(this.getText());
        vector.add(newItem);

        if (parents == null || parents.isEmpty())
            return null;
        else
            for (ChangeItem parent : parents)
                newItem.addChild(parent.collectVector(vector));

        return newItem;
    }

    void addVector(ChangeVector vector) {
        if (vector.isEmpty())
            return;

        ChangeItem matchedChild = hasTextInChildren(vector.getHead().getText());
        if (matchedChild == null)
            addChild(vector.getHead());
        else
            matchedChild.addVector(vector.getTail());
    }

    private ChangeItem hasTextInChildren(String text) {
        for (ChangeItem child : getChildItems())
            if (child.getText().equals(text))
                return child;

        return null;
    }
}