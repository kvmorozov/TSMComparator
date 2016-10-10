package ru.sbt.etsm.drdiff.comparator.logger.model;

import java.lang.reflect.Field;

/**
 * Created by sbt-morozov-kv on 10.08.2016.
 */
public class Descriptor {

    private Field field;
    private String description, keyValue, prefix;
    private Descriptor parentDesc;

    public static final Descriptor MENUS = new Descriptor("menus");
    public static final Descriptor CHANGES = new Descriptor("Changes");
    public static final Descriptor ROOT = new Descriptor("root");

    public Descriptor(Descriptor parentDesc, Field field, String keyValue) {
        this.field = field;
        this.keyValue = isEmpty(keyValue)
                ? isEmpty(parentDesc.keyValue) ? parentDesc.getDescription() : parentDesc.keyValue
                : keyValue;
        this.parentDesc = parentDesc;
    }

    public Descriptor(Descriptor parentDesc, Field field) {
        this(parentDesc, field, "");
    }

    public Descriptor(Descriptor parentDesc, String description) {
        this.description = description;
        this.keyValue = isEmpty(parentDesc.keyValue) ? parentDesc.getDescription() : parentDesc.keyValue;
    }

    private Descriptor(String description) {
        this.description = description;
        this.keyValue = "";
    }

    @Override
    public String toString() {
        return getDescription().isEmpty() ?
                field.getName() + " [" + keyValue + "]" :
                getDescription();
    }

    public Descriptor setPrefix(String prefix) {
        this.prefix = prefix;

        return this;
    }

    public String getDescription() {
        return (prefix == null || prefix.isEmpty() ? ChangeItem.EMPTY_STR : prefix) +
                (description == null || description.isEmpty() ? ChangeItem.EMPTY_STR : description);
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty() || str.equals("/null");
    }
}
