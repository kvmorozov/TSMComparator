package ru.sbt.etsm.drdiff.comparator.context;

import ru.sbt.etsm.drdiff.comparator.matchers.TsmMatcherBase;
import ru.sbt.etsm.drdiff.comparator.serializers.TsmSerializerBase;
import ru.sbt.etsm.drdiff.generated.*;

import java.util.*;
import java.util.Map;

import static ru.sbt.etsm.drdiff.comparator.logger.model.ChangeTree.registerError;

/**
 * Created by sbt-morozov-kv on 11.08.2016.
 */
public class ReportContext {

    private DesignReport report;
    private boolean isNew;
    private Map<String, Table> tablesMap = new HashMap<>();
    private Map<String, Map<String, Criteria>> criteriaMap = new HashMap<>();
    private Map<String, List> refMap = new HashMap<>();
    private Map<Object, Object> cachedReferences = new HashMap<>();

    private static final Set<String> REFERENCES_OBJECTS = new HashSet<>(Arrays.asList("StoredProcedure", "Font", "Status", "Rule", "Sequence", "Action",
            "Map", "Screen", "ScreenTemplate", "QueryScreen", "Condition", "VisibleCondition", "ConditionToProcess", "ConditionalExpression"));

    public ReportContext(DesignReport report, boolean isNew) {
        this.report = report;
        this.isNew = isNew;

        initContext();
    }

    private void initContext() {
        TableList tableList = report.getSetupData().getTableList();
        for (Table table : tableList.getTables()) {
            Map<String, Criteria> tableCriteriaMap = new HashMap<>();
            for (Criteria criteria : table.getCriterias())
                tableCriteriaMap.put(criteria.getPosition(), criteria);

            tablesMap.put(table.getObjectId(), table);
            criteriaMap.put(table.getObjectId(), tableCriteriaMap);
        }
    }

    // $14,560$
    public String decode(String encodedString) {
        String[] codes = encodedString.replace("$", "").split(",");

        if (codes.length != 2)
            throw new AssertionError();

        String tableName = codes[0];
        String criteriaName = codes[1];

        if (tablesMap.containsKey(codes[0])) {
            tableName = tablesMap.get(codes[0]).getName();
            if (criteriaMap.get(codes[0]).containsKey(codes[1]))
                criteriaName = criteriaMap.get(codes[0]).get(codes[1]).getShortName();
        } else
            throw new AssertionError();

        return "$" + tableName + "," + criteriaName + "$";
    }

    public List getRefCollection(String refClassName) {
        List objectsColl = new ArrayList();

        if (REFERENCES_OBJECTS.contains(refClassName)) {
            objectsColl = refMap.get(refClassName);

            if (objectsColl == null) {
                objectsColl = new ArrayList();

                switch (refClassName) {
                    case "StoredProcedure":
                        objectsColl = report.getDesignData().getStoreProcedures().getStoredProcedures();
                        break;
                    case "Font":
                        objectsColl = report.getDesignData().getFonts().getFonts();
                        break;
                    case "Status":
                        objectsColl = report.getDesignData().getStatuses().getStatuses();
                        break;
                    case "Rule":
                        for (Rules rules : report.getDesignData().getRules())
                            objectsColl.addAll(rules.getRules());
                        break;
                    case "Sequence":
                        for (Sequences sequences : report.getDesignData().getSequences())
                            objectsColl.addAll(sequences.getSequences());
                        break;
                    case "Action":
                        objectsColl = report.getDesignData().getActions().getActions();
                        break;
                    case "Map":
                        objectsColl = report.getDesignData().getMaps().getMaps();
                        break;
                    case "Screen":
                        for (Screens screens : report.getDesignData().getScreens())
                            objectsColl.addAll(screens.getScreens());
                        break;
                    case "ScreenTemplate":
                        objectsColl = report.getDesignData().getScreenTemplates().getScreenTemplates();
                        break;
                    case "ConditionalExpression":
                        for (Generations generations : report.getDesignData().getGenerations())
                            objectsColl.addAll(generations.getConditionalExpressions());
                        break;
                    default:
                }

                refMap.put(refClassName, objectsColl);
            }
        }

        return objectsColl;
    }

    public Object resolveReference(Object ref, Class refClass) {
        return resolveReferenceInternal(ref, refClass, true);
    }

    public Object resolveReferenceWithNoCheck(Object ref, Class refClass) {
        return resolveReferenceInternal(ref, refClass, false);
    }

    private Object resolveReferenceInternal(Object ref, Class refClass, boolean withCheck) {
        if (ref == null)
            return null;

        if (withCheck && !isReference(ref))
            return ref;

        Object result = cachedReferences.get(ref);
        if (result == null) {
            List objectsColl = getRefCollection(refClass.getSimpleName());

            if (objectsColl == null || objectsColl.isEmpty())
                return ref;
            else {
                Object matchedObject = objectsColl.isEmpty() ? null : TsmMatcherBase.getMatcher(refClass, objectsColl, this).getMatchedObject(ref);

                if (matchedObject == null)
                    registerError("Unresolved reference: " + TsmSerializerBase.getSerializer(ref).serialize(ref));

                cachedReferences.put(ref, result = matchedObject == null ? ref : matchedObject);
            }
        }

        return result;
    }

    public Object resolveReference(Object ref) {
        if (ref == null)
            return null;

        return resolveReference(ref, TsmMatcherBase.getMatcher(ref.getClass(), this).getBaseClass(ref));
    }

    public static boolean isReference(Object ref) {
        if (ref == null)
            return false;

        return isReference(ref.getClass().getSimpleName());
    }

    public static boolean isReference(String refClassName) {
        if (refClassName == null)
            return false;

        return REFERENCES_OBJECTS.contains(refClassName);
    }

    public boolean isNew() {
        return isNew;
    }
}
