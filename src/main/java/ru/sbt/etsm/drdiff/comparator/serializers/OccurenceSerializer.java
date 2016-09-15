package ru.sbt.etsm.drdiff.comparator.serializers;

import ru.sbt.etsm.drdiff.generated.Occurence;

/**
 * Created by sbt-morozov-kv on 18.08.2016.
 */
public class OccurenceSerializer extends DefaultSerializer {

    @Override
    public String serialize(Object objToSerialize) {
        Occurence occurence = (Occurence) objToSerialize;

        return objToSerialize.getClass().getSimpleName() +
                FIELDS_DELIM +
                (occurence.getOccurenceType() == null ? occurence.getActionType() : occurence.getOccurenceType()) +
                FIELDS_DELIM +
                occurence.getName() +
                FIELDS_DELIM +
                occurence.getIndex();
    }
}
