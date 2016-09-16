package ru.sbt.etsm.drdiff.utils.xstream;

import com.google.common.base.CaseFormat;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.core.util.CompositeClassLoader;
import com.thoughtworks.xstream.mapper.*;
import ru.sbt.etsm.drdiff.generated.*;
import ru.sbt.etsm.drdiff.utils.xstream.converters.AllowDuplicatesConverter;
import ru.sbt.etsm.drdiff.utils.xstream.converters.EnumConverter;
import ru.sbt.etsm.drdiff.utils.xstream.converters.SoapArrayConverter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.beans.Introspector;
import java.lang.reflect.Field;
import java.util.*;
import java.util.Map;

/**
 * Created by sbt-morozov-kv on 21.10.2015.
 */
public class TsmMapper extends CachingMapper {
    private static final Map<Class, String> nodeNamesMap = new HashMap<>();
    private static final Set<Class> allowedDuplicatesClasses = new HashSet<>();

    private static ReflectionProvider _reflectionProvider;

    private TsmMapper(Mapper wrapped) {
        super(wrapped);

        allowedDuplicatesClasses.add(List.class);
        allowedDuplicatesClasses.add(Statuses.class);
        allowedDuplicatesClasses.add(OrderList.class);
        allowedDuplicatesClasses.add(HistoricHiddenCharacteristics.class);
        allowedDuplicatesClasses.add(Menus.class);
        allowedDuplicatesClasses.add(MenuBar.class);
        allowedDuplicatesClasses.add(StoreProcedures.class);
        allowedDuplicatesClasses.add(Fonts.class);
        allowedDuplicatesClasses.add(DesignData.class);
        allowedDuplicatesClasses.add(ActionList.class);
        allowedDuplicatesClasses.add(Actions.class);
        allowedDuplicatesClasses.add(MappingList.class);
        allowedDuplicatesClasses.add(Maps.class);
        allowedDuplicatesClasses.add(GeneratedCharacteristics.class);
        allowedDuplicatesClasses.add(GenerationList.class);
        allowedDuplicatesClasses.add(ScreenTemplates.class);
        allowedDuplicatesClasses.add(TableList.class);
        allowedDuplicatesClasses.add(TableRelationList.class);
        allowedDuplicatesClasses.add(BuilderLayout.class);
        allowedDuplicatesClasses.add(ClientSystem.class);
        allowedDuplicatesClasses.add(Mapping.class);
    }

    private boolean hasDefaultConstructor(Class clazz) {
        try {
            clazz.getDeclaredConstructor();
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    @Override
    public boolean shouldSerializeMember(Class definedIn, String fieldName) {
        try {
            return !fieldName.startsWith("__") && (definedIn != Object.class || realClass(fieldName) != null);
        } catch (CannotResolveClassException cnrce) {
            return false;
        }
    }

    @Override
    public String serializedClass(Class type) {
        if (nodeNamesMap.containsKey(type))
            return nodeNamesMap.get(type);
        return Introspector.decapitalize(type.getSimpleName());
    }

    @Override
    public Class realClass(String elementName) {
        // if (elementName.indexOf(":") > 0)
        try {
            String newElementName = elementName.contains("_") ? CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, elementName) : elementName;

            return super.realClass(newElementName);
        } catch (Exception ex) {
            return Object.class;
        }
    }

    @Override
    public String getFieldNameForItemTypeAndName(Class definedIn, Class itemType, String itemFieldName) {
        for (Field field : definedIn.getDeclaredFields()) {
            if (field.isAnnotationPresent(XmlElement.class)) {
                XmlElement xmlElementAnnot = field.getAnnotation(XmlElement.class);
                if (xmlElementAnnot.name().equalsIgnoreCase(itemFieldName))
                    return field.getName();
            } else if (field.isAnnotationPresent(XmlAttribute.class)) {
                XmlAttribute xmlAttributeAnnot = field.getAnnotation(XmlAttribute.class);
                if (xmlAttributeAnnot.name().equalsIgnoreCase(itemFieldName))
                    return field.getName();
            }

            if (field.getName().equalsIgnoreCase(itemFieldName))
                return field.getName();
        }

        return super.getFieldNameForItemTypeAndName(definedIn, itemType, itemFieldName);
    }

    @Override
    public Class defaultImplementationOf(Class type) {
        Class clazz = super.defaultImplementationOf(type);
        return clazz.isArray() ? clazz.getComponentType() : clazz;
    }

    @Override
    public Converter getLocalConverter(Class definedIn, String fieldName) {
        try {
            Class type = definedIn.getDeclaredField(fieldName).getType();

            boolean useEnumConverter = !type.isPrimitive()
                    && ((!type.isArray() && !hasDefaultConstructor(type) && EnumConverter.getEnumGetter(type) != null)
                    || (type.isArray()
                    && !hasDefaultConstructor(type.getComponentType()) && EnumConverter.getEnumGetter(type.getComponentType()) != null));

            boolean allowedDuplicates = allowedDuplicatesClasses.contains(type);

            if (useEnumConverter || allowedDuplicates) {
                if (useEnumConverter)
                    return new EnumConverter(this, _reflectionProvider, definedIn, fieldName);
                else if (allowedDuplicates) {
                    Field field = definedIn.getDeclaredField(fieldName);
                    Class realClass = definedIn;
                    if (field.isAnnotationPresent(XmlElement.class)) {
                        XmlElement xmlElementAnnot = field.getAnnotation(XmlElement.class);
                        realClass = this.realClass(xmlElementAnnot.name());
                        if (realClass == null || realClass.equals(Object.class))
                            realClass = this.realClass(field.getName());
                    }

                    if (realClass.equals(Object.class))
                        throw new AssertionError();

                    return new AllowDuplicatesConverter(this, _reflectionProvider, definedIn, realClass);
                }
            }

            if (type.isArray())
                return new SoapArrayConverter(this, _reflectionProvider);
        } catch (Exception ignored) {

        }

        return super.getLocalConverter(definedIn, fieldName);
    }

    public static Mapper buildMapper(ReflectionProvider reflectionProvider) {
        _reflectionProvider = reflectionProvider;
        Mapper mapper = new DefaultMapper(new CompositeClassLoader());

        mapper = new DynamicProxyMapper(mapper);
        mapper = new PackageAliasingMapper(mapper);
        mapper = new ClassAliasingMapper(mapper);
        mapper = new FieldAliasingMapper(mapper);
        mapper = new AttributeAliasingMapper(mapper);
        mapper = new SystemAttributeAliasingMapper(mapper);
        mapper = new ImplicitCollectionMapper(mapper);
        mapper = new OuterClassMapper(mapper);
        mapper = new ArrayMapper(mapper);
        mapper = new DefaultImplementationsMapper(mapper);
        mapper = new AttributeMapper(mapper, null, reflectionProvider);

        mapper = new LocalConversionMapper(mapper);
        mapper = new ImmutableTypesMapper(mapper);
        mapper = new SecurityMapper(mapper);

        mapper = new CachingMapper(mapper);
        mapper = new TsmMapper(mapper);
        return mapper;
    }
}
