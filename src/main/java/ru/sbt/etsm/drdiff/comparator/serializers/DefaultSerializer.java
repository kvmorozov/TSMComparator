package ru.sbt.etsm.drdiff.comparator.serializers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.primitives.Primitives;
import ru.sbt.etsm.drdiff.comparator.context.ReportContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ru.sbt.etsm.drdiff.comparator.logger.model.ChangeItem.EMPTY_STR;

/**
 * Created by SBT-Morozov-KV on 12.08.2016.
 */
public class DefaultSerializer extends TsmSerializerBase {

    private static final Pattern rulePattern = Pattern.compile("[$]([0-9])+,([0-9])+[$]");

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String serialize(Object objToSerialize, ReportContext reportContext) {
        if (objToSerialize == null)
            return EMPTY_STR;
        else if (Primitives.isWrapperType(objToSerialize.getClass()))
            return objToSerialize.toString();
        else if (objToSerialize instanceof String && reportContext != null) {
            String originalString = (String) objToSerialize;
            if (originalString.contains("$")) {
                String encodedString = originalString;

                Matcher matcher = rulePattern.matcher(encodedString);
                while (matcher.find()) {
                    String encodedGroup = matcher.group();
                    encodedString = encodedString.replace(encodedGroup, reportContext.decode(encodedGroup));
                }

                return encodedString;
            } else
                return originalString;
        } else
            try {
                return mapper.writeValueAsString(objToSerialize);
            } catch (JsonProcessingException e) {
                return EMPTY_STR;
            }
    }
}
