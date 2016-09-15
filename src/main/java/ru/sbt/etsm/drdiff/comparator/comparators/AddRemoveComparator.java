package ru.sbt.etsm.drdiff.comparator.comparators;

import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeItem;
import ru.sbt.etsm.drdiff.comparator.logger.model.Descriptor;

/**
 * Created by sbt-morozov-kv on 10.08.2016.
 */
public class AddRemoveComparator extends TsmComparatorBase {

    @Override
    protected ChangeItem compare(Descriptor descObject) {
        if (oldObject == null && newObject == null)
            return null;

        return new ChangeItem(descObject, oldObject, newObject)
                .setChangeItemType(oldObject == null ? ChangeItem.ChangeItemType.REMOVE : ChangeItem.ChangeItemType.ADD);
    }
}
