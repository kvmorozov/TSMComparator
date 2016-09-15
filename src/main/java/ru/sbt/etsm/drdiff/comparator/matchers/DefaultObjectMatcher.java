package ru.sbt.etsm.drdiff.comparator.matchers;

import ru.sbt.etsm.drdiff.comparator.context.ReportContext;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.sbt.etsm.drdiff.utils.reflection.ReflectionUtils.isFieldExists;

/**
 * Created by sbt-morozov-kv on 10.08.2016.
 */
public class DefaultObjectMatcher extends TsmMatcherBase {

    protected Map<Class, Field> idFieldsMap = new HashMap<>();

    public Object getKeyValueInternal(Object obj, List contextCollection) {
        try {
            Field idField = getIdField(obj.getClass());

            if (idField == null)
                return null;

            return idField.get(obj);
        } catch (Exception e) {
            return null;
        }
    }

    protected Field getIdField(Class clazz) {
        Field result = idFieldsMap.get(clazz);
        if (result == null) {
            String className = clazz.getSimpleName();

            String fieldName;

            if (ReportContext.isReference(className))
                fieldName = "id";
            else
                switch (className) {
                    case "StatusFlow":
                        fieldName = "statusId";
                        break;
                    case "ConditionStatement":
                        fieldName = "expressionId";
                        break;
                    case "Criteria":
                        fieldName = "shortName";
                        break;
                    case "Order":
                        fieldName = "characteristic";
                        break;
                    case "Appearance":
                        fieldName = "style";
                        break;
                    case "Characteristic":
                        fieldName = "name";
                        break;
                    case "Occurence":
                        fieldName = "id";
                        break;
                    default:
                        if (isFieldExists("elementNb", clazz))
                            fieldName = "elementNb";
                        else if (isFieldExists("name", clazz))
                            fieldName = "name";
                        else if (isFieldExists("id", clazz))
                            fieldName = "id";
                        else
                            fieldName = null;
                }

            if (fieldName != null) {
                try {
                    result = clazz.getDeclaredField(fieldName);
                    result.setAccessible(true);
                    idFieldsMap.put(clazz, result);
                    return result;
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();

                    return null;
                }
            }
        }

        return result;
    }
}
