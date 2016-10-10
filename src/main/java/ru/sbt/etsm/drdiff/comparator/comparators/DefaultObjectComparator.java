package ru.sbt.etsm.drdiff.comparator.comparators;

import ru.sbt.etsm.drdiff.comparator.TsmComparator;
import ru.sbt.etsm.drdiff.comparator.context.ReportContext;
import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeItem;
import ru.sbt.etsm.drdiff.comparator.logger.model.Descriptor;
import ru.sbt.etsm.drdiff.comparator.serializers.TsmSerializerBase;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.stream.Stream;

import static ru.sbt.etsm.drdiff.comparator.logger.model.ChangeItem.EMPTY_STR;

/**
 * Created by sbt-morozov-kv on 10.08.2016.
 */
public class DefaultObjectComparator extends TsmComparatorBase {

    @Override
    protected ChangeItem compare(Descriptor descObject) {
        ChangeItem result = new ChangeItem(descObject, oldObject, newObject);

        if (oldObject == null)
            throw new AssertionError();

        Stream.of(oldObject.getClass().getDeclaredFields()).forEach((field) -> {
                    Object oldFieldObject = getFieldValue(field, oldObject, TsmComparator.getOldReportContext());
                    Object newFieldObject = getFieldValue(field, newObject, TsmComparator.getNewReportContext());

                    ChangeItem changeField = getComparator(oldFieldObject, newFieldObject).compare(new Descriptor(descObject, field));

                    if (changeField != null) {
                        String oldKeyValue = getDisplayKey(oldFieldObject, TsmComparator.getOldReportContext());
                        String newKeyValue = getDisplayKey(newFieldObject, TsmComparator.getNewReportContext());
                        String keyValue = oldKeyValue == null ?
                                newKeyValue == null ? EMPTY_STR : newKeyValue
                                : oldKeyValue;

                        changeField.setDescObject(new Descriptor(descObject, field, keyValue));

                        result.addChild(changeField);
                    }
                }
        );

        return result.getChildCount() == 0 ? null : result;
    }

    private String getDisplayKey(Object obj, ReportContext reportContext) {
        if (obj instanceof Collection)
            return EMPTY_STR;
        else
            return TsmSerializerBase.getSerializer(obj).getDescription(obj) + "/" + getKeyValue(obj, reportContext);
    }

    protected Object getFieldValue(Field field, Object obj, ReportContext reportContext) {
        field.setAccessible(true);
        try {
            return reportContext.resolveReference(field.get(obj));
        } catch (IllegalAccessException e) {
            return null;
        }
    }
}
