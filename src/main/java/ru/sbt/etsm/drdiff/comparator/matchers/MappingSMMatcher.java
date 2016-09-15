package ru.sbt.etsm.drdiff.comparator.matchers;

import ru.sbt.etsm.drdiff.generated.MappingSM;

import java.util.List;

/**
 * Created by sbt-morozov-kv on 10.08.2016.
 */
public class MappingSMMatcher extends TsmMatcherBase {

    @Override
    public Object getKeyValueInternal(Object obj, List contextCollection) {
        if (obj instanceof MappingSM) {
            MappingSM mappingSM = (MappingSM) obj;

            return mappingSM.getTable() + "/" + mappingSM.getDirection() + "/" + mappingSM.getBuilderLayout();
        } else
            return null;
    }
}
