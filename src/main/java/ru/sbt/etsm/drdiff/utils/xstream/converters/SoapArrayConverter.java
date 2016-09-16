package ru.sbt.etsm.drdiff.utils.xstream.converters;

import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.collections.ArrayConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.mapper.Mapper;

import java.lang.reflect.Array;

/**
 * Created by sbt-morozov-kv on 22.10.2015.
 */
public class SoapArrayConverter extends ArrayConverter
{
	private final ReflectionProvider reflectionProvider;

	public SoapArrayConverter(Mapper mapper, ReflectionProvider reflectionProvider)
	{
		super(mapper);
		this.reflectionProvider = reflectionProvider;
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		try
		{
			Object obj = (new ReflectionConverter(mapper(), reflectionProvider)).unmarshal(reader, context);
			Object arrObj = Array.newInstance(obj.getClass(), 1);
			Array.set(arrObj, 0, obj);
			return arrObj;
		}
		catch(Exception ex) {
			return super.unmarshal(reader, context);
		}
	}

	// Если сказал что массив, значит я лучше знаю
	@Override
	public boolean canConvert(Class type) {
		return true;
	}
}
