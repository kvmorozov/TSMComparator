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

        return objToSerialize.getClass().getSimpleName() +
                FIELDS_DELIM +
                characteristic.getTitle() +
                FIELDS_DELIM +
                (characteristic.getCritId() == null ? EMPTY_STR : characteristic.getCritId()) +
                FIELDS_DELIM +
                characteristic.getType();
    }
}
