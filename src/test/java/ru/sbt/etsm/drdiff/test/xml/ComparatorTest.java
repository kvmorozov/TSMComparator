package ru.sbt.etsm.drdiff.test.xml;

import org.junit.Test;
import org.xml.sax.SAXException;
import ru.sbt.etsm.drdiff.comparator.TsmComparator;
import ru.sbt.etsm.drdiff.comparator.logger.file.TsmFileLogger;
import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeTree;
import ru.sbt.etsm.drdiff.generated.DesignReport;
import ru.sbt.etsm.drdiff.utils.jaxb.JaxbHelper;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by sbt-morozov-kv on 10.08.2016.
 */
public class ComparatorTest extends TsmTestBase {

    @Test
    public void compare() throws IOException, JAXBException, SAXException {
        DesignReport oldReport = JaxbHelper.unmarshal(DesignReport.class, prepareData(TEST_DATA_1, true), false);
        DesignReport newReport = JaxbHelper.unmarshal(DesignReport.class, prepareData(TEST_DATA_2, true), false);

        ChangeTree changes = TsmComparator.compare(oldReport, newReport);

        assert (changes != null);

        try (TsmFileLogger logger = new TsmFileLogger(new File("E:\\ETSM\\log\\log" + (new Date()).getTime() + ".txt"))) {
            logger.logReport(changes);
        }
    }
}
