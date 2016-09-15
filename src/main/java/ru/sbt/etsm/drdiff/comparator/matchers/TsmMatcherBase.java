package ru.sbt.etsm.drdiff.comparator.matchers;

import ru.sbt.etsm.drdiff.comparator.TsmComparator;
import ru.sbt.etsm.drdiff.comparator.context.ReportContext;
import ru.sbt.etsm.drdiff.generated.Rule;
import ru.sbt.etsm.drdiff.generated.Screen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.sbt.etsm.drdiff.utils.reflection.ReflectionUtils.isFieldExists;

/**
 * Created by sbt-morozov-kv on 10.08.2016.
 */
public abstract class TsmMatcherBase {

    private static final Object NULL_OBJECT = new Object();

    protected ReportContext context;
    private Map<Object, List<Object>> collectionsMap = new HashMap<>();
    protected List originalCollection;
    protected List ownCollection;
    private Map<Object, Object> keysMap = new HashMap<>();

    public Object getMatchedObject(Object objectToMatch) {
        Object keyValue = getKeyValue(objectToMatch, ownCollection);

        if (keyValue == null)
            return null;

        return collectionsMap.containsKey(keyValue) ? collectionsMap.get(keyValue).get(0) : null;
    }

    public Object getMatchedObjectSwitchContext(Object objectToMatch) {
        context = context.isNew() ? TsmComparator.getOldReportContext() : TsmComparator.getNewReportContext();

        Object result = getMatchedObject(objectToMatch);

        context = context.isNew() ? TsmComparator.getOldReportContext() : TsmComparator.getNewReportContext();

        return result;
    }

    protected abstract Object getKeyValueInternal(Object obj, List contextCollection);

    public Object getKeyValue(Object obj, List contextCollection) {
        Object result = keysMap.get(obj);
        if (result == NULL_OBJECT)
            return null;
        else if (result != null)
            return result;
        else {
            result = getKeyValueInternal(obj, contextCollection);
            if (contextCollection == null || contextCollection.isEmpty() || result == null)
                keysMap.put(obj, result == null ? NULL_OBJECT : result);

            return result;
        }
    }

    public Class getBaseClass(Object obj) {
        return obj.getClass();
    }

    public <T> T setCollectionToCheck(List collectionToCheck) {
        this.originalCollection = collectionToCheck;

        for (Object item : collectionToCheck) {
            Object keyValue = getKeyValue(item, collectionToCheck);
            if (keyValue == null)
                continue;

            List<Object> itemsList = collectionsMap.get(keyValue);
            if (itemsList == null) {
                itemsList = new ArrayList<>();

                itemsList.add(item);
                collectionsMap.put(keyValue, itemsList);
            } else
                itemsList.add(item);
        }

        return (T) this;
    }

    public static TsmMatcherBase getMatcher(Class objClass, List collectionToCheck, ReportContext context) {
        return collectionToCheck == null ? getMatcher(objClass, context) : getMatcher(objClass, context).setCollectionToCheck(collectionToCheck);
    }

    public void setOwnCollection(List ownCollection) {
        this.ownCollection = ownCollection;
    }

    public static TsmMatcherBase getMatcher(Class objClass, ReportContext context) {
        TsmMatcherBase matcher;

        String className = objClass.getSimpleName();

        if (ReportContext.isReference(className))
            return new DefaultObjectMatcher();
        else
            switch (className) {
                case "TableRelation":
                    matcher = new TableRelationMatcher();
                    break;
                case "MappingSM":
                    matcher = new MappingSMMatcher();
                    break;
                case "Element":
                    matcher = new ElementMatcher();
                    break;
                case "Occurence":
                    matcher = new OccurenceMatcher();
                    break;
                case "QueryScreen":
                    matcher = new ConvertingMatcher(context, Screen.class);
                    break;
                case "Characteristic":
                    matcher = new CharacteristicMatcher();
                    break;
                case "Condition":
                case "VisibleCondition":
                case "ConditionToProcess":
                    matcher = new ConvertingMatcher(context, Rule.class);
                    break;
                case "Option":
                    matcher = new SimpleObjectMatcher();
                    break;
                default:
                    if (isFieldExists("type", objClass) && isFieldExists("id", objClass))
                        matcher = new TypeIdMatcher();
                    else
                        matcher = new DefaultObjectMatcher();
            }

        return matcher;
    }
}
