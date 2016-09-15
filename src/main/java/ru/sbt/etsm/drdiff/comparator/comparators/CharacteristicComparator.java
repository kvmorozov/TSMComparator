package ru.sbt.etsm.drdiff.comparator.comparators;

import ru.sbt.etsm.drdiff.comparator.context.ReportContext;
import ru.sbt.etsm.drdiff.generated.Rule;

import java.lang.reflect.Field;

/**
 * Created by SBT-Morozov-KV on 17.08.2016.
 */
public class CharacteristicComparator extends SkipFieldsComparator {

    public CharacteristicComparator() {
        super(CHARACTERISTIC_SET);
    }

    private class FakeIdHolder {
        String id;

        FakeIdHolder(String id) {
            this.id = id;
        }
    }

    @Override
    protected Object getFieldValue(Field field, Object obj, ReportContext reportContext) {
        Object result = super.getFieldValue(field, obj, reportContext);

        if (result == null)
            return null;
        else {
            switch (field.getName()) {
                case "visibilityCond":
                case "outputCond":
                    return reportContext.resolveReferenceWithNoCheck(new FakeIdHolder(result.toString()), Rule.class);
                default:
                    return result;
            }
        }
    }
}
