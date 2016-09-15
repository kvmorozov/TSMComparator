package ru.sbt.etsm.drdiff.comparator.comparators.collections;

import ru.sbt.etsm.drdiff.comparator.TsmComparator;
import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeItem;
import ru.sbt.etsm.drdiff.comparator.logger.model.Descriptor;
import ru.sbt.etsm.drdiff.comparator.matchers.OccurenceMatcher;
import ru.sbt.etsm.drdiff.comparator.serializers.TsmSerializerBase;
import ru.sbt.etsm.drdiff.generated.Occurence;

/**
 * Created by SBT-Morozov-KV on 15.08.2016.
 */
public class OccurencesCollectionComparator extends CollectionComparator {

    private static final boolean LOOK_ALL_FLAG = false;

    @Override
    public ChangeItem compare(Descriptor descObject) {
        if (oldCollection.size() == 0 && newCollection.size() == 0)
            return null;
        else if (oldCollection.size() == 0)
            return new ChangeItem(new Descriptor(COLL_STRING), null, newCollection);
        else if (newCollection.size() == 0)
            return new ChangeItem(new Descriptor(COLL_STRING), oldCollection, null);

        ChangeItem result = new ChangeItem(descObject, oldObject, newObject);

        for (int index = 0; index < oldCollection.size(); index++) {
            Occurence oldItem = (Occurence) oldCollection.get(index);
            if (newCollection.size() <= index)
                return new ChangeItem(new Descriptor(ITEM_STRING), oldItem, null);
            else {
                Object newItem = newCollection.get(index);

                Object oldItemResolved = OccurenceMatcher.resolveReference(oldItem, TsmComparator.getOldReportContext());
                if (oldItemResolved == null)
                    oldItemResolved = oldItem;

                ChangeItem change = compare(getComparator(oldItem, newItem), new Descriptor(oldItemResolved.getClass().getSimpleName() +
                        " [[" +
                        TsmSerializerBase.getSerializer(oldItemResolved).getDescription(oldItemResolved) +
                        "]/" +
                        getKeyValue(oldItemResolved, oldCollection, TsmComparator.getOldReportContext()) +
                        "]"));

                if (change != null) {
                    result.addChild(change);
                    break;
                }
            }
        }

        if (result.getChildCount() == 0 && newCollection.size() > oldCollection.size())
            result.addChild(new ChangeItem(new Descriptor(ITEM_STRING), newCollection.get(oldCollection.size()), null));

        if (LOOK_ALL_FLAG) {
            OccurenceMatcher newMatcher = (new OccurenceMatcher(false)).setCollectionToCheck(newCollection);
            OccurenceMatcher oldMatcher = (new OccurenceMatcher(false)).setCollectionToCheck(oldCollection);
            CollectionComparator fullComparator = new CollectionComparator(newMatcher, oldMatcher);
            fullComparator.init(oldObject, newObject);

            ChangeItem fullResult = compare(fullComparator, descObject);

            if (fullResult != null && fullResult.getChildCount() > 0)
                for (ChangeItem item : fullResult.getChildItems())
                    result.addChild(item);
        }

        return result.getChildCount() == 0 ? null : result;
    }
}
