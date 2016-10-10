package ru.sbt.etsm.drdiff.comparator.comparators.collections;

import ru.sbt.etsm.drdiff.comparator.TsmComparator;
import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeItem;
import ru.sbt.etsm.drdiff.comparator.logger.model.Descriptor;
import ru.sbt.etsm.drdiff.comparator.matchers.TsmMatcherBase;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by sbt-morozov-kv on 18.08.2016.
 */
public class CharacteristicCollectionComparator extends CollectionComparator {

    @Override
    protected ChangeItem compare(Descriptor descObject) {
        if (oldCollection.size() == 0 && newCollection.size() == 0)
            return null;
        else if (oldCollection.size() == 0)
            return new ChangeItem(new Descriptor(descObject, COLL_STRING), null, newCollection);
        else if (newCollection.size() == 0)
            return new ChangeItem(new Descriptor(descObject, COLL_STRING), oldCollection, null);

        elemClass = oldCollection.get(0).getClass();

        if (dontCheck())
            return null;

        Map<Object, Object> matches = new HashMap<>();

        TsmMatcherBase oldMatcher = getCollectionMatcher(elemClass, oldCollection, TsmComparator.getOldReportContext());
        TsmMatcherBase newMatcher = getCollectionMatcher(elemClass, newCollection, TsmComparator.getNewReportContext());
        oldMatcher.setOwnCollection(oldCollection);
        newMatcher.setOwnCollection(oldCollection);

        List oldCollectionCloned = new LinkedList<>(oldCollection);
        List newCollectionCloned = new LinkedList<>(newCollection);

        oldCollectionCloned.stream().forEach((item) -> {
                    newMatcher.setCollectionToCheck(newCollectionCloned);

                    Object matchedItemInNewCollection = newMatcher.getMatchedObject(item);
                    if (matchedItemInNewCollection != null) {
                        matches.put(item, matchedItemInNewCollection);

                        if (!newCollectionCloned.remove(matchedItemInNewCollection) && !newCollection.contains(matchedItemInNewCollection))
                            throw new AssertionError();
                    } else {
                        Object realOldItem = oldMatcher.getMatchedObject(item);
                        if (realOldItem != null)
                            matches.put(item, null);
                    }
                }
        );

        newCollectionCloned.stream().filter(item -> !matches.containsValue(item)).forEach(item -> matches.put(null, newMatcher.getMatchedObject(item)));

        newMatcher.setCollectionToCheck(newCollection);

        return processMatches(descObject, matches);
    }
}
