package ru.sbt.etsm.drdiff.comparator.matchers;

import ru.sbt.etsm.drdiff.generated.TableRelation;

import java.util.List;

/**
 * Created by sbt-morozov-kv on 10.08.2016.
 */
public class TableRelationMatcher extends TsmMatcherBase {

    @Override
    public Object getKeyValueInternal(Object obj, List contextCollection) {
        if (obj instanceof TableRelation) {
            TableRelation tableRelation = (TableRelation) obj;

            return tableRelation.getType() + "/" + tableRelation.getTablesrc() + "/" + tableRelation.getTabledst();
        } else
            return null;
    }
}
