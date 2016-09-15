package ru.sbt.etsm.drdiff.comparator.matchers;

import ru.sbt.etsm.drdiff.comparator.context.ReportContext;
import ru.sbt.etsm.drdiff.generated.Action;
import ru.sbt.etsm.drdiff.generated.Occurence;
import ru.sbt.etsm.drdiff.generated.Screen;
import ru.sbt.etsm.drdiff.generated.Sequence;

import java.util.List;

import static ru.sbt.etsm.drdiff.comparator.logger.model.ChangeTree.registerError;

/**
 * Created by sbt-morozov-kv on 10.08.2016.
 */
public class OccurenceMatcher extends TsmMatcherBase {

    private boolean isOrdered;

    public OccurenceMatcher() {
        this(true);
    }

    public OccurenceMatcher(boolean isOrdered) {
        this.isOrdered = isOrdered;
    }

    @Override
    public Object getKeyValueInternal(Object obj, List contextCollection) {
        if (obj instanceof Occurence) {
            Occurence occurence = (Occurence) obj;

            String order = isOrdered ?
                    occurence.getIndex() == null ? String.valueOf(originalCollection.indexOf(obj)) : occurence.getIndex() :
                    occurence.getId();

            return (occurence.getOccurenceType() == null ? occurence.getActionType() : occurence.getOccurenceType()) + "/" + order;
        } else
            return null;
    }

    public static Object resolveReference(Occurence occurence, ReportContext reportContext) {
        Class lookupClass = null;
        String occurenceType = occurence.getOccurenceType() == null ? occurence.getActionType() : occurence.getOccurenceType();

        switch (occurenceType) {
            case "Action":
                lookupClass = Action.class;
                break;
            case "Sequence":
                lookupClass = Sequence.class;
                break;
            case "Generation":
//                    lookupClass = ConditionalExpression.class;
                break;
            case "Screen":
                lookupClass = Screen.class;
                break;
            case "Hook":
            case "Save Event":
            case "Save":
            case "Predefined Occurences":
            case "Get Parameter":
            case "Message":
            case "Status flow":
            case "Decision":
                registerError("Unknown Occurence type: " + occurenceType);
                break;
            default:
                throw new AssertionError(occurenceType);
        }

        return lookupClass == null ? null : reportContext.resolveReferenceWithNoCheck(occurence, lookupClass);
    }
}
