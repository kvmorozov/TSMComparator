package ru.sbt.etsm.drdiff.comparator.comparators;

import ru.sbt.etsm.drdiff.comparator.TsmComparator;
import ru.sbt.etsm.drdiff.comparator.matchers.ConvertingMatcher;
import ru.sbt.etsm.drdiff.generated.Screen;

import java.util.Set;

/**
 * Created by sbt-morozov-kv on 12.08.2016.
 */
public class QueryScreenComparator extends SkipFieldsComparator {

    public QueryScreenComparator() {
        super(SCREEN_SET);
    }

    @Override
    protected void init(Object oldObject, Object newObject) {
        this.oldObject = new ConvertingMatcher(TsmComparator.getOldReportContext(), Screen.class).getMatchedObject(oldObject);
        this.newObject = new ConvertingMatcher(TsmComparator.getNewReportContext(), Screen.class).getMatchedObject(oldObject);
    }
}
