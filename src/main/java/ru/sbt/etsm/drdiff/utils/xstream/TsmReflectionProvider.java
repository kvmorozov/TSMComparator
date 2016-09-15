package ru.sbt.etsm.drdiff.utils.xstream;

import com.thoughtworks.xstream.converters.reflection.MissingFieldException;
import com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.beans.Introspector;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sbt-morozov-kv on 20.10.2015.
 */
public class TsmReflectionProvider extends PureJavaReflectionProvider {

    private Field _getFieldOrNull(Class definedIn, String fieldName) {
        if (definedIn == null)
            throw new AssertionError();

        for (Field field : definedIn.getDeclaredFields()) {
            if (field.isAnnotationPresent(XmlElement.class)) {
                XmlElement xmlElementAnnot = field.getAnnotation(XmlElement.class);
                if (xmlElementAnnot.name().equalsIgnoreCase(fieldName))
                    return field;
            } else if (field.isAnnotationPresent(XmlAttribute.class)) {
                XmlAttribute xmlAttributeAnnot = field.getAnnotation(XmlAttribute.class);
                if (xmlAttributeAnnot.name().equalsIgnoreCase(fieldName))
                    return field;
            }

            if (field.getName().equalsIgnoreCase(fieldName))
                return field;
        }

        Field field = super.getFieldOrNull(definedIn, fieldName);
        if (field == null) {
            field = super.getFieldOrNull(definedIn, Introspector.decapitalize(fieldName));
        }

        return field;
    }

    @Override
    public Field getFieldOrNull(Class definedIn, String fieldName) {
        Field field = _getFieldOrNull(definedIn, fieldName);

        return field == null ? null : field;
    }

    @Override
    public Field getField(Class definedIn, String fieldName) {
        Field result;

        try {
            result = super.getField(definedIn, fieldName);
        } catch (MissingFieldException mfe) {
            result = null;
        }

        return result == null ? this.getFieldOrNull(definedIn, fieldName) : result;
    }

    @Override
    public void writeField(Object object, String fieldName, Object value, Class definedIn) {
        Field field = null;
        try {
            field = definedIn == null ? object.getClass().getDeclaredField(fieldName) : _getFieldOrNull(definedIn, fieldName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        if (field == null)
            throw new AssertionError();

        this.validateFieldAccess(field);

        try {
            if (field.getType().isArray()) {
                Object objs = field.get(object);
                Class baseClass = field.getType().getComponentType();
                // В value к нам придёт одноэлементный массив, созданный в EnumConverter.unmarshal или SoapArrayConverter.unmarshal
                if (objs == null) {
                    field.set(object, value);
                } else {
                    Object elem = ((Object[]) value)[0];
                    Object[] arr = (Object[]) objs;
                    Object arrObj = Array.newInstance(baseClass, arr.length + 1);
                    for (int i = 0; i < arr.length; i++)
                        Array.set(arrObj, i, arr[i]);

                    Array.set(arrObj, arr.length, elem);
                    field.set(object, arrObj);
                }
            } else
                field.set(object, value);
        } catch (Exception ex) {

        }
    }

    @Override
    public Object newInstance(Class type) {
        Object result = null;
        try {
            result = super.newInstance(type);
        } catch (Exception ex) {
            // Если это что-то типа SPName_Type
            try {
                Field _tableField = type.getDeclaredField("_table_");
                if (_tableField != null) {
                    _tableField.setAccessible(true);
                    HashMap map = (HashMap) _tableField.get(null);
                    return (new ArrayList(map.values())).get(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
