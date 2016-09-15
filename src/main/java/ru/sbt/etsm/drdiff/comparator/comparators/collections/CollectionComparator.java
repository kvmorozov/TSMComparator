package ru.sbt.etsm.drdiff.comparator.comparators.collections;

import ru.sbt.etsm.drdiff.comparator.TsmComparator;
import ru.sbt.etsm.drdiff.comparator.comparators.TsmComparatorBase;
import ru.sbt.etsm.drdiff.comparator.context.ReportContext;
import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeItem;
import ru.sbt.etsm.drdiff.comparator.logger.model.Descriptor;
import ru.sbt.etsm.drdiff.comparator.matchers.ConvertingMatcher;
import ru.sbt.etsm.drdiff.comparator.matchers.TsmMatcherBase;
import ru.sbt.etsm.drdiff.comparator.serializers.TsmSerializerBase;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static ru.sbt.etsm.drdiff.comparator.matchers.TsmMatcherBase.getMatcher;

/**
 * Created by sbt-morozov-kv on 10.08.2016.
 */
public class CollectionComparator extends TsmComparatorBase {

    protected Class elemClass;
    protected List<Object> oldCollection, newCollection;

    protected static final String COLL_STRING = "Collection";
    protected static final String ITEM_STRING = "Item";

    private TsmMatcherBase newMatcher, oldMatcher;

    CollectionComparator(TsmMatcherBase newMatcher, TsmMatcherBase oldMatcher) {
        this.newMatcher = newMatcher;
        this.oldMatcher = oldMatcher;
    }

    public CollectionComparator() {
        this(null, null);
    }

    @Override
    protected void init(Object oldObject, Object newObject) {
        super.init(oldObject, newObject);

        oldCollection = (List) oldObject;
        newCollection = (List) newObject;
    }

    protected static boolean isCollHomogene(List list) {
        if (list == null || list.isEmpty())
            return true;

        Class firstElementType = list.get(0).getClass();
        for (Object elem : list)
            if (!elem.getClass().equals(firstElementType))
                return false;

        return true;
    }

    protected TsmMatcherBase getCollectionMatcher(Class firstElementClass, List collection, ReportContext reportContext) {
        return getMatcher(firstElementClass, collection, reportContext);
    }

    @Override
    protected ChangeItem compare(Descriptor descObject) {
        if (oldCollection.size() == 0 && newCollection.size() == 0)
            return null;
        else if (oldCollection.size() == 0)
            return new ChangeItem(new Descriptor(COLL_STRING), null, newCollection);
        else if (newCollection.size() == 0)
            return new ChangeItem(new Descriptor(COLL_STRING), oldCollection, null);

        elemClass = oldCollection.get(0).getClass();

        if (dontCheck())
            return null;

        Map<Object, Object> matches = new HashMap<>();

        newMatcher = newMatcher == null ? getCollectionMatcher(elemClass, newCollection, TsmComparator.getNewReportContext()) : newMatcher;
        oldMatcher = oldMatcher == null ? getCollectionMatcher(elemClass, oldCollection, TsmComparator.getNewReportContext()) : oldMatcher;

        List newCollectionCloned = new LinkedList<>(newCollection);

        for (Object item : oldCollection) {
            Object matchedItemInNewCollection = newMatcher.getMatchedObject(item);
            if (matchedItemInNewCollection != null) {
                if (item.getClass().equals(matchedItemInNewCollection.getClass())) {
                    matches.put(item, matchedItemInNewCollection);
                    if (!newCollectionCloned.remove(matchedItemInNewCollection) && !newCollection.contains(matchedItemInNewCollection))
                        throw new AssertionError();
                } else {
                    Object convertedItemInOldCollection = newMatcher.getMatchedObjectSwitchContext(item);
                    matches.put(convertedItemInOldCollection, matchedItemInNewCollection);

                    Object originalMatchedItem = ((ConvertingMatcher) newMatcher).getMatchedObject(item, false);
                    if (!newCollectionCloned.remove(originalMatchedItem))
                        throw new AssertionError();
                }
            } else {
                // Пропускаем через матчер, чтобы отбросить игнорируемые объекты
                Object realOldItem = oldMatcher.getMatchedObject(item);
                if (realOldItem != null)
                    matches.put(item, null);
            }
        }

        newCollectionCloned.stream().filter(item -> !matches.containsValue(item)).forEach(item -> matches.put(null, newMatcher.getMatchedObject(item)));

        return processMatches(descObject, matches);
    }

    protected ChangeItem processMatches(Descriptor descObject, Map<Object, Object> matches) {
        ChangeItem result = new ChangeItem(descObject, oldObject, newObject);

        for (Map.Entry<Object, Object> pair : matches.entrySet())
            if (pair.getKey() == null && pair.getValue() == null)
                continue;
            else if (pair.getKey() == null)
                result.addChild(new ChangeItem(new Descriptor(ITEM_STRING), null, pair.getValue()));
            else if (pair.getValue() == null)
                result.addChild(new ChangeItem(new Descriptor(ITEM_STRING), pair.getKey(), null));
            else {
                ChangeItem change = compare(getComparator(pair.getKey(), pair.getValue()),
                        new Descriptor(elemClass.getSimpleName() +
                                " [" +
                                TsmSerializerBase.getSerializer(pair.getKey()).getDescription(pair.getKey()) +
                                "/" +
                                getKeyValue(pair.getKey(), oldCollection, TsmComparator.getOldReportContext()) +
                                "]")
                );
                if (change != null)
                    result.addChild(change);
            }

        return result.getChildCount() == 0 ? null : result;
    }

    @Override
    protected boolean dontCheck() {
        switch (elemClass.getSimpleName()) {
            case "Generation":
            case "Attrib":
            case "StatusFlow":
                return true;
            default:
                return super.dontCheck();
        }
    }

    public static CollectionComparator getCollectionComparator(Object oldObject, Object newObject) {
        CollectionComparator comparator;

        if (!isCollHomogene((List) oldObject) || !isCollHomogene((List) newObject))
            comparator = new HeterogeneCollectionComparator();
        else {
            if (((List) oldObject).size() == 0 || ((List) newObject).size() == 0)
                comparator = new CollectionComparator();
            else {
                Class elemClass = ((List) oldObject).get(0).getClass();
                switch (elemClass.getSimpleName()) {
                    case "Occurence":
                        comparator = new OccurencesCollectionComparator();
                        break;
                    case "Characteristic":
                        comparator = new CharacteristicCollectionComparator();
                        break;
                    case "ConditionStatement":
                        comparator = new OrderedCollectionComparator();
                        break;
                    case "MenuBar":
                        comparator = new MenuBarCollectionComparator();
                        break;
                    default:
                        comparator = new CollectionComparator();
                }
            }
        }

        comparator.init(oldObject, newObject);

        return comparator;
    }
}
