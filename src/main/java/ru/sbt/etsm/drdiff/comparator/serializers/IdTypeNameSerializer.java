package ru.sbt.etsm.drdiff.comparator.serializers;

import static ru.sbt.etsm.drdiff.utils.reflection.ReflectionUtils.getFieldValue;

/**
 * Created by SBT-Morozov-KV on 12.08.2016.
 */
public class IdTypeNameSerializer extends TsmSerializerBase {

    @Override
    public String serialize(Object objToSerialize) {
        return new StringBuilder()
                .append(objToSerialize.getClass().getSimpleName())
                .append(FIELDS_DELIM)
                .append(getFieldValue("type", objToSerialize))
                .append(FIELDS_DELIM)
                .append(getFieldValue("id", objToSerialize))
                .append(FIELDS_DELIM)
                .append(getFieldValue("name", objToSerialize))
                .toString();
    }
}
