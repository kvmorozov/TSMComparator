package ru.sbt.etsm.drdiff.utils.xstream.converters;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ObjectAccessException;
import com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.core.util.HierarchicalStreams;
import com.thoughtworks.xstream.core.util.Primitives;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;
import com.thoughtworks.xstream.mapper.Mapper;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by sbt-morozov-kv on 21.10.2015.
 */
public class AllowDuplicatesConverter extends ReflectionConverter {
    private transient ReflectionProvider pureJavaReflectionProvider;
    private Class realType;

    public AllowDuplicatesConverter(Mapper mapper, ReflectionProvider reflectionProvider, Class type, Class realType) {
        super(mapper, reflectionProvider, type);

        this.realType = realType;
    }

    @Override
    public Object doUnmarshal(final Object result, final HierarchicalStreamReader reader,
                              final UnmarshallingContext context) {
        final Class resultType = result.getClass();

        // process attributes before recursing into child elements.
        Iterator it = reader.getAttributeNames();
        while (it.hasNext()) {
            String attrAlias = (String) it.next();
            String attrName = mapper
                    .realMember(resultType, mapper.attributeForAlias(attrAlias));
            Field field = reflectionProvider.getFieldOrNull(resultType, attrName);
            if (field != null && shouldUnmarshalField(field)) {
                Class classDefiningField = field.getDeclaringClass();
                if (!mapper.shouldSerializeMember(classDefiningField, attrName)) {
                    continue;
                }

                // we need a converter that produces a string representation only
                SingleValueConverter converter = mapper.getConverterFromAttribute(
                        classDefiningField, attrName, field.getType());
                Class type = field.getType();
                if (converter != null) {
                    Object value = converter.fromString(reader.getAttribute(attrAlias));
                    if (type.isPrimitive()) {
                        type = Primitives.box(type);
                    }
                    if (value != null && !type.isAssignableFrom(value.getClass())) {
                        throw new ConversionException("Cannot convert type "
                                + value.getClass().getName()
                                + " to type "
                                + type.getName());
                    }
                    reflectionProvider.writeField(result, attrName, value, classDefiningField);
                }
            }
        }

        Map implicitCollectionsForCurrentObject = null;
        while (reader.hasMoreChildren()) {
            reader.moveDown();

            String originalNodeName = reader.getNodeName();
            Class explicitDeclaringClass = readDeclaringClass(reader);
            Class fieldDeclaringClass = explicitDeclaringClass == null
                    ? resultType
                    : explicitDeclaringClass;
            String fieldName = mapper.realMember(fieldDeclaringClass, originalNodeName);
            Mapper.ImplicitCollectionMapping implicitCollectionMapping = mapper
                    .getImplicitCollectionDefForFieldName(fieldDeclaringClass, fieldName);
            final Object value;
            String implicitFieldName = null;
            Field field = null;
            Class type = null;
            if (implicitCollectionMapping == null) {
                // no item of an implicit collection for this name ... do we have a field?
                field = reflectionProvider.getFieldOrNull(realType, fieldName);
                if (field == null) {
                    // it is not a field ... do we have a field alias?
                    Class itemType = mapper.getItemTypeForItemFieldName(resultType, fieldName);
                    if (itemType != null) {
                        String classAttribute = HierarchicalStreams.readClassAttribute(
                                reader, mapper);
                        if (classAttribute != null) {
                            type = mapper.realClass(classAttribute);
                        } else {
                            type = itemType;
                        }
                    } else {
                        // it is not an alias ... do we have an element of an implicit
                        // collection based on type only?
                        try {
                            type = mapper.realClass(originalNodeName);
                            implicitFieldName = mapper.getFieldNameForItemTypeAndName(
                                    context.getRequiredType(), type, originalNodeName);
                        } catch (CannotResolveClassException e) {
                            // type stays null ...
                        }
                        if (type == null || (type != null && implicitFieldName == null)) {
                            // either not a type or element is a type alias, but does not
                            // belong to an implicit field
                            handleUnknownField(
                                    explicitDeclaringClass, fieldName, resultType, originalNodeName);

                            // element is unknown in declaring class, ignore it now
                            type = null;
                        }
                    }
                    if (type == null) {
                        // no type, no value
                        value = null;
                    } else {
                        if (Map.Entry.class.equals(type)) {
                            // it is an element of an implicit map with two elements now for
                            // key and value
                            reader.moveDown();
                            final Object key = context.convertAnother(
                                    result, HierarchicalStreams.readClassType(reader, mapper));
                            reader.moveUp();
                            reader.moveDown();
                            final Object v = context.convertAnother(
                                    result, HierarchicalStreams.readClassType(reader, mapper));
                            reader.moveUp();
                            value = Collections.singletonMap(key, v)
                                    .entrySet().iterator().next();
                        } else {
                            // recurse info hierarchy
                            value = context.convertAnother(result, type, this);
                        }
                    }
                } else {
                    boolean fieldAlreadyChecked = false;

                    // we have a field, but do we have to address a hidden one?
                    if (explicitDeclaringClass == null) {
                        while (field != null
                                && !(fieldAlreadyChecked = shouldUnmarshalField(field)
                                && mapper.shouldSerializeMember(
                                field.getDeclaringClass(), fieldName))) {
                            field = reflectionProvider.getFieldOrNull(field
                                    .getDeclaringClass()
                                    .getSuperclass(), fieldName);
                        }
                    }
                    if (field != null
                            && (fieldAlreadyChecked || (shouldUnmarshalField(field) && mapper
                            .shouldSerializeMember(field.getDeclaringClass(), fieldName)))) {

                        String classAttribute = HierarchicalStreams.readClassAttribute(
                                reader, mapper);
                        if (classAttribute != null) {
                            type = mapper.realClass(classAttribute);
                        } else {
                            type = mapper.defaultImplementationOf(field.getType());
                        }
                        value = unmarshallField(context, result, type, field);
                        Class definedType = field.getType();
                        if (!definedType.isPrimitive()) {
                            type = definedType;
                        }
                    } else {
                        value = null;
                    }
                }
            } else {
                // we have an implicit collection with defined names
                implicitFieldName = implicitCollectionMapping.getFieldName();
                type = implicitCollectionMapping.getItemType();
                if (type == null) {
                    String classAttribute = HierarchicalStreams.readClassAttribute(
                            reader, mapper);
                    type = mapper.realClass(classAttribute != null
                            ? classAttribute
                            : originalNodeName);
                }
                value = context.convertAnother(result, type);
            }

            if (value != null && !type.isAssignableFrom(value.getClass())) {
                throw new ConversionException("Cannot convert type "
                        + value.getClass().getName()
                        + " to type "
                        + type.getName());
            }

            if (field != null) {
                reflectionProvider.writeField(result, fieldName, value, field.getDeclaringClass());
            } else if (type != null) {
                if (implicitFieldName == null) {
                    // look for implicit field
                    implicitFieldName = mapper.getFieldNameForItemTypeAndName(
                            context.getRequiredType(),
                            value != null ? value.getClass() : Mapper.Null.class,
                            originalNodeName);
                }
                if (implicitCollectionsForCurrentObject == null) {
                    implicitCollectionsForCurrentObject = new HashMap();
                }
                writeValueToImplicitCollection(
                        value, implicitCollectionsForCurrentObject, result, implicitFieldName);
            }

            reader.moveUp();
        }

        if (implicitCollectionsForCurrentObject != null) {
            for (Object o : implicitCollectionsForCurrentObject.entrySet()) {
                Map.Entry entry = (Map.Entry) o;
                Object value = entry.getValue();
                if (value instanceof ArraysList) {
                    Object array = ((ArraysList) value).toPhysicalArray();
                    reflectionProvider.writeField(result, (String) entry.getKey(), array, null);
                }
            }
        }

        return result;
    }

    private Class readDeclaringClass(HierarchicalStreamReader reader) {
        String attributeName = mapper.aliasForSystemAttribute("defined-in");
        String definedIn = attributeName == null ? null : reader.getAttribute(attributeName);
        return definedIn == null ? null : mapper.realClass(definedIn);
    }

    private void handleUnknownField(Class classDefiningField, String fieldName,
                                    Class resultType, String originalNodeName) {
        if (classDefiningField == null) {
            for (Class cls = resultType; cls != null; cls = cls.getSuperclass()) {
                if (!mapper.shouldSerializeMember(cls, originalNodeName)) {
                    return;
                }
            }
        }
//        throw new UnknownFieldException(resultType.getName(), fieldName);
    }

    private void writeValueToImplicitCollection(Object value, Map implicitCollections, Object result, String implicitFieldName) {
        Collection collection = (Collection) implicitCollections.get(implicitFieldName);
        if (collection == null) {
            Class physicalFieldType = reflectionProvider.getFieldType(
                    result, implicitFieldName, null);
            if (physicalFieldType.isArray()) {
                collection = new ArraysList(physicalFieldType);
            } else {
                Class fieldType = mapper.defaultImplementationOf(physicalFieldType);
                if (!(Collection.class.isAssignableFrom(fieldType) || Map.class
                        .isAssignableFrom(fieldType))) {
                    return;
/*
                    throw new ObjectAccessException(
                            "Field "
                                    + implicitFieldName
                                    + " of "
                                    + result.getClass().getName()
                                    + " is configured for an implicit Collection or Map, but field is of type "
                                    + fieldType.getName());
*/
                }
                if (pureJavaReflectionProvider == null) {
                    pureJavaReflectionProvider = new PureJavaReflectionProvider();
                }
                Object instance = pureJavaReflectionProvider.newInstance(fieldType);
                if (instance instanceof Collection) {
                    collection = (Collection) instance;
                } else {
                    Mapper.ImplicitCollectionMapping implicitCollectionMapping = mapper
                            .getImplicitCollectionDefForFieldName(result.getClass(), implicitFieldName);
                    collection = new MappingList(
                            (Map) instance, implicitCollectionMapping.getKeyFieldName());
                }
                reflectionProvider.writeField(result, implicitFieldName, instance, null);
            }
            implicitCollections.put(implicitFieldName, collection);
        }
        collection.add(value);
    }

    private static class ArraysList extends ArrayList {
        final Class physicalFieldType;

        ArraysList(Class physicalFieldType) {
            this.physicalFieldType = physicalFieldType;
        }

        Object toPhysicalArray() {
            Object[] objects = toArray();
            Object array = Array.newInstance(
                    physicalFieldType.getComponentType(), objects.length);
            if (physicalFieldType.getComponentType().isPrimitive()) {
                for (int i = 0; i < objects.length; ++i) {
                    Array.set(array, i, Array.get(objects, i));
                }
            } else {
                System.arraycopy(objects, 0, array, 0, objects.length);
            }
            return array;
        }
    }

    private class MappingList extends AbstractList {

        private final Map map;
        private final String keyFieldName;
        private final Map fieldCache = new HashMap();

        public MappingList(Map map, String keyFieldName) {
            this.map = map;
            this.keyFieldName = keyFieldName;
        }

        public boolean add(Object object) {
            if (object == null) {
                boolean containsNull = !map.containsKey(null);
                map.put(null, null);
                return containsNull;
            }
            Class itemType = object.getClass();

            if (keyFieldName != null) {
                Field field = (Field) fieldCache.get(itemType);
                if (field == null) {
                    field = reflectionProvider.getField(itemType, keyFieldName);
                    fieldCache.put(itemType, field);
                }
                if (field != null) {
                    try {
                        Object key = field.get(object);
                        return map.put(key, object) == null;
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        throw new ObjectAccessException("Could not get field "
                                + field.getClass()
                                + "."
                                + field.getName(), e);
                    }
                }
            } else if (object instanceof Map.Entry) {
                final Map.Entry entry = (Map.Entry) object;
                return map.put(entry.getKey(), entry.getValue()) == null;
            }

            throw new ConversionException("Element of type "
                    + object.getClass().getName()
                    + " is not defined as entry for map of type "
                    + map.getClass().getName());
        }

        public Object get(int index) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return map.size();
        }
    }

    @Override
    public boolean canConvert(Class type) {
        return true;
    }
}
