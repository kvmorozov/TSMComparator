package ru.sbt.etsm.drdiff.utils.xstream.converters;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

/**
 * Created by sbt-morozov-kv on 21.10.2015.
 */
public class EnumConverter extends ReflectionConverter
{
	private static final String ENUM_GETTER_METHOD_NAME = "fromValue";
	private Method _getter;
	private boolean isArray;
	private Class realClass;

	public static Method getEnumGetter(Class clazz) {
		try
		{
			return clazz.getMethod(ENUM_GETTER_METHOD_NAME, String.class);
		}
		catch (NoSuchMethodException e)
		{
			return null;
		}
	}

	public EnumConverter(Mapper mapper, ReflectionProvider reflectionProvider, Class type, String fieldName)
	{
		super(mapper, reflectionProvider, type);

		try
		{
			Class clazz = type.getDeclaredField(fieldName).getType();
			isArray = clazz.isArray();
			realClass = isArray ? clazz.getComponentType() : clazz;
			_getter =  getEnumGetter(realClass);
		}
		catch (NoSuchFieldException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public Object unmarshal(final HierarchicalStreamReader reader,
	                        final UnmarshallingContext context) {
		try
		{
			// Соверешнно не понятно, почему штатный конвертер так не умеет. Тупо не делает reader.getValue()
			// На вызове метода я не настаиваю, но штатный конвертер просто тупо думает, что нет значения
			Object result = _getter.invoke(null, reader.getValue());
			if (isArray) {
				Object arrObj = Array.newInstance(realClass, 1);
				Array.set(arrObj, 0, result);
				return arrObj;
			}
			else
				return result;
		}
		catch (Exception e)
		{
			return super.unmarshal(reader, context);
		}
	}

	@Override
	public boolean canConvert(Class type) {
		return _getter != null;
	}
}
