package ru.sbt.etsm.drdiff.comparator.serializers;

import com.google.common.primitives.Primitives;
import ru.sbt.etsm.drdiff.comparator.context.ReportContext;
import ru.sbt.etsm.drdiff.generated.Characteristic;
import ru.sbt.etsm.drdiff.generated.Occurence;

import java.util.Collection;

import static ru.sbt.etsm.drdiff.comparator.logger.model.ChangeItem.EMPTY_STR;
import static ru.sbt.etsm.drdiff.utils.reflection.ReflectionUtils.getFieldValue;
import static ru.sbt.etsm.drdiff.utils.reflection.ReflectionUtils.isFieldExists;

/**
 * Created by SBT-Morozov-KV on 12.08.2016.
 */
public abstract class TsmSerializerBase {

    private static final TsmSerializerBase DEFAULT_SERIALIZER = new DefaultSerializer();
    private static final TsmSerializerBase ID_TYPE_SERIALIZER = new IdTypeNameSerializer();
    private static final TsmSerializerBase OCCURENCE_SERIALIZER = new OccurenceSerializer();
    private static final TsmSerializerBase CHARACTERISTIC_SERIALIZER = new CharacteristicSerializer();

    public static final String FIELDS_DELIM = "/";

    public static TsmSerializerBase getSerializer(Object obj) {
        TsmSerializerBase serializer;

        if (obj == null)
            serializer = new DefaultSerializer();
        else {
            if (obj instanceof Occurence)
                serializer = OCCURENCE_SERIALIZER;
            else if (obj instanceof Characteristic)
                serializer = CHARACTERISTIC_SERIALIZER;
            else {
                Class objClass = obj.getClass();
                if (isFieldExists("id", objClass) && isFieldExists("type", objClass) && isFieldExists("name", objClass))
                    serializer = ID_TYPE_SERIALIZER;
                else
                    serializer = DEFAULT_SERIALIZER;
            }
        }

        return serializer;
    }

    public abstract String serialize(Object objToSerialize, ReportContext reportContext);

    public String serialize(Object objToSerialize) {
        return serialize(objToSerialize, null);
    }

    public String getDescription(Object objToSerialize) {
        if (objToSerialize == null)
            return EMPTY_STR;
        else if (Primitives.isWrapperType(objToSerialize.getClass()) || objToSerialize instanceof Collection || objToSerialize instanceof String)
            return EMPTY_STR;
        else {
            String descFieldName = getDescriptionFieldName(objToSerialize.getClass());
            return descFieldName == null ? EMPTY_STR : getFieldValue(descFieldName, objToSerialize).toString();
        }
    }

    private String getDescriptionFieldName(Class _class) {
        if (isFieldExists("name", _class))
            return "name";
        else
            return null;
    }
}
