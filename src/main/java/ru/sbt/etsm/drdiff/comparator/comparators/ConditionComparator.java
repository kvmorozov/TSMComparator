package ru.sbt.etsm.drdiff.comparator.comparators;

import ru.sbt.etsm.drdiff.comparator.TsmComparator;
import ru.sbt.etsm.drdiff.comparator.matchers.ConvertingMatcher;
import ru.sbt.etsm.drdiff.generated.Rule;

import java.util.Set;

/**
 * Created by sbt-morozov-kv on 12.08.2016.
 */
public class ConditionComparator extends RuleComparator {

    public ConditionComparator(Set<String> skipFields) {
        super(skipFields);
    }

    @Override
    protected void init(Object oldObject, Object newObject) {
        this.oldObject = new ConvertingMatcher(TsmComparator.getOldReportContext(), Rule.class).getMatchedObject(oldObject);
        this.newObject = new ConvertingMatcher(TsmComparator.getNewReportContext(), Rule.class).getMatchedObject(oldObject);
    }
}
