package ru.sbt.etsm.drdiff.comparator.comparators;

import ru.sbt.etsm.drdiff.comparator.context.ReportContext;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * Created by sbt-morozov-kv on 11.08.2016.
 */
public class SkipFieldsComparator extends DefaultObjectComparator {

    protected final Set<String> skipFields;

    public SkipFieldsComparator(Set<String> skipFields) {
        this.skipFields = skipFields;
    }

    @Override
    protected Object getFieldValue(Field field, Object obj, ReportContext reportContext) {
        return skipFields.contains(field.getName()) ? null : super.getFieldValue(field, obj, reportContext);
    }
}
