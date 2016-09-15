package ru.sbt.etsm.drdiff.comparator.matchers;

import ru.sbt.etsm.drdiff.comparator.context.ReportContext;

import java.lang.reflect.Field;

/**
 * Created by sbt-morozov-kv on 12.08.2016.
 */
public class ConvertingMatcher extends DefaultObjectMatcher {

   private final Class convertToClass;

    public ConvertingMatcher(ReportContext context, Class convertToClass) {
        this.context = context;
        this.convertToClass = convertToClass;
    }

    @Override
    public Object getMatchedObject(Object objectToMatch) {
        return getMatchedObject(objectToMatch, true);
    }

    public Object getMatchedObject(Object objectToMatch, boolean convert) {
        if (convert && originalCollection != null) {
            Object notConvertedMatch = getNotConvertingMatchedObject(objectToMatch);
            return notConvertedMatch == null ? null : context.resolveReference(objectToMatch, convertToClass);
        }

        return convert ? context.resolveReference(objectToMatch, convertToClass) : getNotConvertingMatchedObject(objectToMatch);
    }

    private Object getNotConvertingMatchedObject(Object objectToMatch) {
        return super.getMatchedObject(objectToMatch);
    }

    @Override
    public Class getBaseClass(Object obj) {
        return convertToClass;
    }

    @Override
    protected Field getIdField(Class clazz) {
        Field result = idFieldsMap.get(clazz);
        if (result == null) {
            String fieldName = "id";

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

        return result;
    }
}
