package ru.sbt.etsm.drdiff.comparator.matchers;

import java.util.List;

import static ru.sbt.etsm.drdiff.utils.reflection.ReflectionUtils.getFieldValue;

/**
 * Created by sbt-morozov-kv on 10.08.2016.
 */
public class TypeIdMatcher extends TsmMatcherBase {

    @Override
    public Object getKeyValueInternal(Object obj, List contextCollection) {
        return getFieldValue("type", obj).toString() + "/" + getFieldValue("id", obj).toString();
    }
}
