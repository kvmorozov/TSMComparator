package ru.sbt.etsm.drdiff.comparator.comparators;

import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeItem;
import ru.sbt.etsm.drdiff.comparator.logger.model.Descriptor;
import ru.sbt.etsm.drdiff.generated.DesignReport;

/**
 * Created by sbt-morozov-kv on 11.08.2016.
 */
public class MainComparator extends TsmComparatorBase {

    @Override
    protected ChangeItem compare(Descriptor descObject) {
        DesignReport oldReport = (DesignReport) oldObject;
        DesignReport newReport = (DesignReport) newObject;

        return getComparator(oldReport.getDesignData().getMenus(), newReport.getDesignData().getMenus()).compare(Descriptor.MENUS);
    }
}
