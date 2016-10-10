package ru.sbt.etsm.drdiff.comparator;

import ru.sbt.etsm.drdiff.comparator.comparators.TsmComparatorBase;
import ru.sbt.etsm.drdiff.comparator.context.ReportContext;
import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeTree;
import ru.sbt.etsm.drdiff.comparator.logger.model.Descriptor;
import ru.sbt.etsm.drdiff.generated.DesignReport;

import static ru.sbt.etsm.drdiff.comparator.comparators.TsmComparatorBase.getComparator;

/**
 * Created by sbt-morozov-kv on 09.08.2016.
 */
public class TsmComparator {

    private static final TsmComparator INSTANCE = new TsmComparator();
    private ReportContext oldReportContext, newReportContext;

    private TsmComparator() {
    }

    public static ChangeTree compare(DesignReport oldReport, DesignReport newReport) {
        INSTANCE.oldReportContext = new ReportContext(oldReport, false);
        INSTANCE.newReportContext = new ReportContext(newReport, true);

        return new ChangeTree(TsmComparatorBase.compare(getComparator(oldReport, newReport), Descriptor.ROOT));
    }

    public static ReportContext getOldReportContext() {
        return INSTANCE.oldReportContext;
    }

    public static ReportContext getNewReportContext() {
        return INSTANCE.newReportContext;
    }
}
