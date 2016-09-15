package ru.sbt.etsm.drdiff.comparator.serializers;

import ru.sbt.etsm.drdiff.generated.Characteristic;

import static ru.sbt.etsm.drdiff.comparator.logger.model.ChangeItem.EMPTY_STR;

/**
 * Created by sbt-morozov-kv on 18.08.2016.
 */
public class CharacteristicSerializer extends DefaultSerializer {

    @Override
    public String serialize(Object objToSerialize) {
        Characteristic characteristic = (Characteristic) objToSerialize;

        return new StringBuilder()
                .append(objToSerialize.getClass().getSimpleName())
                .append(FIELDS_DELIM)
                .append(characteristic.getTitle())
                .append(FIELDS_DELIM)
                .append(characteristic.getCritId() == null ? EMPTY_STR : characteristic.getCritId())
                .append(FIELDS_DELIM)
                .append(characteristic.getType())
                .toString();
    }
}
