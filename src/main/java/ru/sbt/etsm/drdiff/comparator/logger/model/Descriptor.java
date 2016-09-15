package ru.sbt.etsm.drdiff.comparator.logger.model;

import java.lang.reflect.Field;

/**
 * Created by sbt-morozov-kv on 10.08.2016.
 */
public class Descriptor {

    private Field field;
    private String description, keyValue, prefix;

    public Descriptor(Field field, String keyValue) {
        this.field = field;
        this.keyValue = keyValue;
    }

    public Descriptor(Field field) {
        this(field, "");
    }

    public Descriptor(String description) {
        this.description = description;
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
}
