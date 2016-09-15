package ru.sbt.etsm.drdiff.comparator.matchers;

import ru.sbt.etsm.drdiff.generated.Element;

import java.util.List;

/**
 * Created by sbt-morozov-kv on 10.08.2016.
 */
public class ElementMatcher extends TsmMatcherBase {

    @Override
    public Object getKeyValueInternal(Object obj, List contextCollection) {
        if (obj instanceof Element) {
            Element element = (Element) obj;

            return element.getTrsTableName() + "/" + element.getPcTableName();
        } else
            return null;
    }
}
