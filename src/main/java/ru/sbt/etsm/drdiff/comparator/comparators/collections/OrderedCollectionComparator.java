package ru.sbt.etsm.drdiff.comparator.comparators.collections;

import ru.sbt.etsm.drdiff.comparator.TsmComparator;
import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeItem;
import ru.sbt.etsm.drdiff.comparator.logger.model.Descriptor;
import ru.sbt.etsm.drdiff.comparator.serializers.TsmSerializerBase;

/**
 * Created by sbt-morozov-kv on 24.08.2016.
 */
public class OrderedCollectionComparator extends CollectionComparator {

    @Override
    public ChangeItem compare(Descriptor descObject) {
        if (oldCollection.size() == 0 && newCollection.size() == 0)
            return null;
        else if (oldCollection.size() == 0)
            return new ChangeItem(new Descriptor(descObject, COLL_STRING), null, newCollection);
        else if (newCollection.size() == 0)
            return new ChangeItem(new Descriptor(descObject, COLL_STRING), oldCollection, null);

        ChangeItem result = new ChangeItem(descObject, oldObject, newObject);

        for (int index = 0; index < oldCollection.size(); index++) {
            Object oldItem = oldCollection.get(index);
            if (newCollection.size() <= index)
                return new ChangeItem(new Descriptor(descObject, ITEM_STRING), oldItem, null);
            else {
                Object newItem = newCollection.get(index);

                ChangeItem change = compare(getComparator(oldItem, newItem), new Descriptor(descObject, oldItem.getClass().getSimpleName() +
                        " [[" +
                        TsmSerializerBase.getSerializer(oldItem).getDescription(oldItem) +
                        "]/" +
                        getKeyValue(oldItem, oldCollection, TsmComparator.getOldReportContext()) +
                        "]"));

                if (change != null) {
                    result.addChild(change);
                    break;
                }
            }
        }

        if (result.getChildCount() == 0 && newCollection.size() > oldCollection.size())
            result.addChild(new ChangeItem(new Descriptor(descObject, ITEM_STRING), newCollection.get(oldCollection.size()), null));

        return result.getChildCount() == 0 ? null : result;
    }
}
