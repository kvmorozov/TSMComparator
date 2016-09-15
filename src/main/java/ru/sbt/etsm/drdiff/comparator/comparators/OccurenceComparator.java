package ru.sbt.etsm.drdiff.comparator.comparators;

import ru.sbt.etsm.drdiff.comparator.TsmComparator;
import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeItem;
import ru.sbt.etsm.drdiff.comparator.logger.model.Descriptor;
import ru.sbt.etsm.drdiff.comparator.matchers.OccurenceMatcher;
import ru.sbt.etsm.drdiff.generated.Occurence;

/**
 * Created by SBT-Morozov-KV on 16.08.2016.
 */
public class OccurenceComparator extends DefaultObjectComparator {

    @Override
    protected ChangeItem compare(Descriptor descObject) {
        Occurence oldOccurence = (Occurence) oldObject;
        Occurence newOccurence = (Occurence) newObject;

        ChangeItem result = super.compare(descObject);

        if (result == null) {
            Object refOldObject = OccurenceMatcher.resolveReference(oldOccurence, TsmComparator.getOldReportContext());
            Object refNewObject = OccurenceMatcher.resolveReference(newOccurence, TsmComparator.getNewReportContext());

            if (refOldObject == null || refNewObject == null)
                return null;

            if (refOldObject instanceof Occurence || refNewObject instanceof Occurence)
                return null;

            result = getComparator(refOldObject, refNewObject).compare(descObject);

            return result;
        } else
            return result;
    }
}
