package ru.sbt.etsm.drdiff.comparator.comparators;

import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeItem;
import ru.sbt.etsm.drdiff.comparator.logger.model.Descriptor;
import ru.sbt.etsm.drdiff.comparator.serializers.TsmSerializerBase;

/**
 * Created by SBT-Morozov-KV on 15.08.2016.
 */
public class SimpleObjectComparator extends TsmComparatorBase {

    @Override
    protected ChangeItem compare(Descriptor descObject) {
        String oldObjectStr = TsmSerializerBase.getSerializer(oldObject).serialize(oldObject);
        String newObjectStr = TsmSerializerBase.getSerializer(newObject).serialize(newObject);

        return oldObjectStr.equals(newObjectStr) ?
                null :
                new ChangeItem(descriptor, oldObject, newObject);
    }
}
