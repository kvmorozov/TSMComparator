package ru.sbt.etsm.drdiff.comparator.comparators.collections;

import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeItem;
import ru.sbt.etsm.drdiff.comparator.logger.model.Descriptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SBT-Morozov-KV on 16.08.2016.
 */
public class HeterogeneCollectionComparator extends CollectionComparator {

    @Override
    public ChangeItem compare(Descriptor descObject) {
        if (oldCollection.size() == 0 && newCollection.size() == 0)
            return null;
        else if (oldCollection.size() == 0)
            return new ChangeItem(new Descriptor(COLL_STRING), null, newCollection);
        else if (newCollection.size() == 0)
            return new ChangeItem(new Descriptor(COLL_STRING), oldCollection, null);

        ChangeItem result = new ChangeItem(descObject, oldObject, newObject);

        Map<String, List> oldSplittedCollection = splitCollectionByType(oldCollection);
        Map<String, List> newSplittedCollection = splitCollectionByType(newCollection);

        for (Map.Entry<String, List> entry : oldSplittedCollection.entrySet()) {
            String elemClass = entry.getKey();

            List newList = newSplittedCollection.containsKey(elemClass) ? newSplittedCollection.get(elemClass) : null;
            ChangeItem change = compare(getComparator(entry.getValue(), newList), new Descriptor(elemClass));
            if (change != null)
                result.addChild(change);
        }

        for (Map.Entry<String, List> entry : newSplittedCollection.entrySet()) {
            String elemClass = entry.getKey();
            if (!oldSplittedCollection.containsKey(elemClass))
                result.addChild(new ChangeItem(new Descriptor(elemClass), null, entry.getValue()));
        }

        return result.getChildCount() == 0 ? null : result;
    }

    private Map<String, List> splitCollectionByType(List items) {
        Map<String, List> result = new HashMap<>();

        for (Object item : items) {
            String objClass = item.getClass().getSimpleName();
            if (!result.containsKey(objClass)) {
                result.put(objClass, new ArrayList<>());
            }

            result.get(objClass).add(item);
        }

        return result;
    }
}
