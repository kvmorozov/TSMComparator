package ru.sbt.etsm.drdiff.comparator.comparators;

import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeItem;
import ru.sbt.etsm.drdiff.comparator.logger.model.Descriptor;

/**
 * Created by sbt-morozov-kv on 10.08.2016.
 */
public class PrimitiveComparator extends TsmComparatorBase {

    @Override
    protected ChangeItem compare(Descriptor descObject) {
        return oldObject.toString().equals(newObject.toString()) ?
                null :
                new ChangeItem(descriptor, oldObject, newObject);
    }
}
