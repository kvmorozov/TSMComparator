package ru.sbt.etsm.drdiff.comparator.serializers;

import ru.sbt.etsm.drdiff.comparator.context.ReportContext;

import static ru.sbt.etsm.drdiff.utils.reflection.ReflectionUtils.getFieldValue;

/**
 * Created by SBT-Morozov-KV on 12.08.2016.
 */
public class IdTypeNameSerializer extends TsmSerializerBase {

    @Override
    public String serialize(Object objToSerialize, ReportContext reportContext) {
        return objToSerialize.getClass().getSimpleName() +
                FIELDS_DELIM +
                getFieldValue("type", objToSerialize) +
                FIELDS_DELIM +
                getFieldValue("id", objToSerialize) +
                FIELDS_DELIM +
                getFieldValue("name", objToSerialize);
    }
}
