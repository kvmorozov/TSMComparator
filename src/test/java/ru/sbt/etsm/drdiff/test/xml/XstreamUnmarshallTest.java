package ru.sbt.etsm.drdiff.test.xml;

import org.junit.Test;
import ru.sbt.etsm.drdiff.utils.xstream.XmlConverter;

import java.io.IOException;

/**
 * Created by sbt-morozov-kv on 09.08.2016.
 */
public class XstreamUnmarshallTest extends TsmTestBase {

    @Test
    public void loadData() throws IOException {
        XmlConverter reportConverter = new XmlConverter("ru.sbt.etsm.drdiff.generated", null, true);

        checkData(reportConverter.deserialize(prepareData(TEST_DATA_1, false)));
    }

}
