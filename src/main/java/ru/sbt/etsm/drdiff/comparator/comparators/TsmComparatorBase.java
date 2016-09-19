package ru.sbt.etsm.drdiff.comparator.comparators;

import com.google.common.primitives.Primitives;
import ru.sbt.etsm.drdiff.comparator.comparators.collections.CollectionComparator;
import ru.sbt.etsm.drdiff.comparator.context.ReportContext;
import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeItem;
import ru.sbt.etsm.drdiff.comparator.logger.model.Descriptor;
import ru.sbt.etsm.drdiff.comparator.matchers.TsmMatcherBase;
import ru.sbt.etsm.drdiff.generated.*;

import java.util.*;
import java.util.Map;

/**
 * Created by sbt-morozov-kv on 10.08.2016.
 */
public abstract class TsmComparatorBase {

    private static final ChangeItem NULL_OBJECT = ChangeItem.NULL_CHANGE;

    private static final Map<Object, Map<Object, ChangeItem>> compareCache = new HashMap<>();

    protected Object oldObject, newObject;
    protected Descriptor descriptor;

    public static final Set<String> ID_SET = new HashSet<>(Arrays.asList("id"));
    public static final Set<String> ELEMENT_NB_SET = new HashSet<>(Arrays.asList("elementNb"));
    public static final Set<String> SCREEN_SET = new HashSet<>(Arrays.asList("id", "top", "left", "right", "bottom"));
    public static final Set<String> CHARACTERISTIC_SET = new HashSet<>(Arrays.asList("appearance", "options", "tabOrder", "title", "id", "caption"));
    public static final Set<String> RULE_SET = new HashSet<>(Arrays.asList("ruleDescription", "id", "name", "comment"));
    public static final Set<String> COND_STAT_SET = new HashSet<>(Arrays.asList("expressionDescription", "conditionDescription", "comment"));

    protected void init(Object oldObject, Object newObject) {
        this.oldObject = oldObject;
        this.newObject = newObject;
    }

    protected abstract ChangeItem compare(Descriptor descObject);

    public static TsmComparatorBase getComparator(Object oldObject, Object newObject) {
        TsmComparatorBase comparator;

        if (oldObject == null || newObject == null)
            comparator = new AddRemoveComparator();
        else if (!oldObject.getClass().equals(newObject.getClass()))
            comparator = new NotComparableComparator();
        else if (!oldObject.getClass().equals(newObject.getClass()))
            comparator = new NotComparableComparator();
        else if (oldObject instanceof String || Primitives.isWrapperType(oldObject.getClass()))
            comparator = new PrimitiveComparator();
        else if (oldObject instanceof Collection)
            return CollectionComparator.getCollectionComparator(oldObject, newObject);
        else if (oldObject instanceof Rule)
            comparator = new RuleComparator();
        else if (oldObject instanceof Condition || oldObject instanceof VisibleCondition || oldObject instanceof ConditionToProcess)
            comparator = new ConditionComparator();
        else if (oldObject instanceof QueryScreen)
            comparator = new QueryScreenComparator();
        else if (oldObject instanceof DesignReport)
            comparator = new MainComparator();
        else if (oldObject instanceof ConditionStatement)
            comparator = new ConditionStatementComparator();
        else if (oldObject instanceof Occurence)
            comparator = new OccurenceComparator();
        else if (oldObject instanceof Characteristic)
            comparator = new CharacteristicComparator();
        else if (oldObject instanceof Option)
            comparator = new SimpleObjectComparator();
        else if (oldObject instanceof Screen)
            comparator = new SkipFieldsComparator(SCREEN_SET);
        else if (oldObject instanceof Action)
            comparator = new SkipFieldsComparator(ID_SET);
        else if (oldObject instanceof ActionList)
            comparator = new SkipFieldsComparator(ELEMENT_NB_SET);
        else
            comparator = new DefaultObjectComparator();

        comparator.init(oldObject, newObject);

        return comparator;
    }

    protected boolean dontCheck() {
        return false;
    }

    protected String getKeyValue(Object obj, ReportContext context) {
        return getKeyValue(obj, null, context);
    }

    protected String getKeyValue(Object obj, List collectionToCheck, ReportContext context) {
        if (obj == null || obj instanceof Collection)
            return null;
        else if (obj instanceof String || Primitives.isWrapperType(obj.getClass()))
            return null;
        else {
            Object keyValue = TsmMatcherBase.getMatcher(obj.getClass(), collectionToCheck, context).getKeyValue(obj, collectionToCheck);
            if (keyValue == null)
                return ChangeItem.EMPTY_STR;
            else
                return keyValue.toString();
        }
    }

    ChangeItem getCachedValue() {
        if (oldObject == null || newObject == null)
            return null;
        else {
            Map<Object, ChangeItem> newMapCache = compareCache.get(oldObject);
            return newMapCache == null ? null : newMapCache.get(newObject);
        }
    }

    ChangeItem putInCache(ChangeItem change) {
        if (oldObject != null && newObject != null) {
            Map<Object, ChangeItem> newMapCache = compareCache.get(oldObject);
            if (newMapCache == null) {
                compareCache.put(oldObject, newMapCache = new HashMap<>());
                newMapCache.put(newObject, change == null ? NULL_OBJECT : change);
            }
        }

        return change;
    }

    public static ChangeItem compare(TsmComparatorBase comparator, Descriptor descObject) {
        ChangeItem cachedValue = comparator.getCachedValue();
        if (cachedValue == null)
            return comparator.putInCache(comparator.compare(descObject));
        else {
            return cachedValue == NULL_OBJECT ? null : cachedValue.setDescObject(descObject);
        }
    }
}
