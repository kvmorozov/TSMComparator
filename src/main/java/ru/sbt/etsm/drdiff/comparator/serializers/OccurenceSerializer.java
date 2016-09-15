package ru.sbt.etsm.drdiff.comparator.serializers;

import ru.sbt.etsm.drdiff.generated.Occurence;

/**
 * Created by sbt-morozov-kv on 18.08.2016.
 */
public class OccurenceSerializer extends DefaultSerializer {

    @Override
    public String serialize(Object objToSerialize) {
        Occurence occurence = (Occurence) objToSerialize;

        return new StringBuilder()
                .append(objToSerialize.getClass().getSimpleName())
                .append(FIELDS_DELIM)
                .append(occurence.getOccurenceType() == null ? occurence.getActionType() : occurence.getOccurenceType())
                .append(FIELDS_DELIM)
                .append(occurence.getName())
                .append(FIELDS_DELIM)
                .append(occurence.getIndex())
                .toString();
    }
}
