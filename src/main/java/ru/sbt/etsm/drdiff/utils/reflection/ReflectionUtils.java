package ru.sbt.etsm.drdiff.utils.reflection;

import java.lang.reflect.Field;

/**
 * Created by SBT-Morozov-KV on 12.08.2016.
 */
public class ReflectionUtils {

    public static boolean isFieldExists(String fieldName, Class clazz) {
        try {
            return clazz.getDeclaredField(fieldName) != null;
        } catch (NoSuchFieldException e) {
            return false;
        }
    }

    public static Object getFieldValue(String fieldName, Object obj) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            Object result = field.get(obj);
            return result == null ? "" : result;
        } catch (Exception e) {
            return "";
        }
    }
}
