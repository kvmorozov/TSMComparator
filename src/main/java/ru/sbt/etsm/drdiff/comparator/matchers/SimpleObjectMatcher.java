package ru.sbt.etsm.drdiff.comparator.matchers;

import ru.sbt.etsm.drdiff.comparator.serializers.TsmSerializerBase;

import java.util.List;

/**
 * Created by sbt-morozov-kv on 10.08.2016.
 */
public class SimpleObjectMatcher extends TsmMatcherBase {

    @Override
    public Object getKeyValueInternal(Object obj, List contextCollection) {
        return TsmSerializerBase.getSerializer(obj).serialize(obj);
    }
}
