package ru.sbt.etsm.drdiff.comparator.comparators;

import ru.sbt.etsm.drdiff.comparator.context.ReportContext;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sbt-morozov-kv on 11.08.2016.
 */
public class RuleComparator extends SkipFieldsComparator {

    private static final Pattern pattern = Pattern.compile("[$]([0-9])+,([0-9])+[$]");

    public RuleComparator() {
        super(RULE_SET);
    }

    @Override
    protected Object getFieldValue(Field field, Object obj, ReportContext reportContext) {
        if (skipFields.contains(field.getName().toLowerCase()))
            return null;

        Object result = super.getFieldValue(field, obj, reportContext);

        if (result instanceof String && ((String) result).contains("$")) {
            String encodedString = (String) result;

            Matcher matcher = pattern.matcher(encodedString);
            while (matcher.find()) {
                String encodedGroup = matcher.group();
                encodedString = encodedString.replace(encodedGroup, reportContext.decode(encodedGroup));
            }

            return encodedString;
        } else
            return result;
    }
}
