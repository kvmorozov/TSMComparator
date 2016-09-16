package ru.sbt.etsm.drdiff.comparator.serializers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.primitives.Primitives;

import static ru.sbt.etsm.drdiff.comparator.logger.model.ChangeItem.EMPTY_STR;

/**
 * Created by SBT-Morozov-KV on 12.08.2016.
 */
public class DefaultSerializer extends TsmSerializerBase {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String serialize(Object objToSerialize) {
        if (objToSerialize == null)
            return EMPTY_STR;
        else if (Primitives.isWrapperType(objToSerialize.getClass()))
            return objToSerialize.toString();
        else
            try {
                return mapper.writeValueAsString(objToSerialize);
            } catch (JsonProcessingException e) {
                return EMPTY_STR;
            }
    }
}
