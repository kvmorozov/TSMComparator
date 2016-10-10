package ru.sbt.etsm.drdiff.comparator.comparators;

import ru.sbt.etsm.drdiff.comparator.TsmComparator;
import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeItem;
import ru.sbt.etsm.drdiff.comparator.logger.model.Descriptor;
import ru.sbt.etsm.drdiff.comparator.serializers.TsmSerializerBase;

/**
 * Created by SBT-Morozov-KV on 15.08.2016.
 */
public class SimpleObjectComparator extends TsmComparatorBase {

    @Override
    protected ChangeItem compare(Descriptor descObject) {
        String oldObjectStr = TsmSerializerBase.getSerializer(oldObject).serialize(oldObject, TsmComparator.getOldReportContext());
        String newObjectStr = TsmSerializerBase.getSerializer(newObject).serialize(newObject, TsmComparator.getNewReportContext());

        return oldObjectStr.equals(newObjectStr) ?
                null :
                new ChangeItem(descriptor, oldObject, newObject);
    }
}
