package ru.sbt.etsm.drdiff.test.xml;

import org.junit.Test;
import org.xml.sax.SAXException;
import ru.sbt.etsm.drdiff.generated.DesignReport;
import ru.sbt.etsm.drdiff.utils.jaxb.JaxbHelper;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created by sbt-morozov-kv on 08.08.2016.
 */
public class JaxbUnmarshallTest extends TsmTestBase {

    @Test
    public void loadData() throws JAXBException, SAXException, IOException {
        checkData(JaxbHelper.unmarshal(DesignReport.class, prepareData(TEST_DATA_1, true), true));
    }
}
