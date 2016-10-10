package ru.sbt.etsm.drdiff.comparator.logger.model;

/**
 * Created by sbt-morozov-kv on 10.08.2016.
 */
public class Descriptor {

    private String fieldName;
    private String keyValue;
    private Descriptor parentDesc;

    public static final Descriptor MENUS = new Descriptor("menus");
    public static final Descriptor CHANGES = new Descriptor("Changes");
    public static final Descriptor ROOT = new Descriptor("root");

    public Descriptor(Descriptor parentDesc, String fieldName, String keyValue) {
        this.fieldName = fieldName;
        this.keyValue = isEmpty(keyValue) ? parentDesc.keyValue : keyValue;
        this.parentDesc = parentDesc;
    }

    public Descriptor(Descriptor parentDesc, String keyValue) {
        this(parentDesc, parentDesc.fieldName, keyValue);
    }

    private Descriptor(String keyValue) {
        this.keyValue = keyValue;
    }

    @Override
    public String toString() {
        return fieldName + " [" + keyValue + "]";
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty() || str.equals("/null");
    }
}
