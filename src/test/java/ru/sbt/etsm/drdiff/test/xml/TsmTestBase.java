package ru.sbt.etsm.drdiff.test.xml;

import com.google.common.io.Resources;
import ru.sbt.etsm.drdiff.generated.DesignData;
import ru.sbt.etsm.drdiff.generated.DesignReport;
import ru.sbt.etsm.drdiff.utils.jaxb.JaxbHelper;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by sbt-morozov-kv on 09.08.2016.
 */
public class TsmTestBase {

    protected static final String TEST_DATA_1 = "xml/test/sberbank_TDS_HF00.xml";
    protected static final String TEST_DATA_2 = "xml/test/sberbank_TDS_HF01.xml";

    protected static char sign_quote = '"';

    protected void checkData(DesignReport designReport) {
        assert (designReport != null);

        DesignData designData = designReport.getDesignData();

        assert (designData != null);
        assert (designData.getActions() != null);
        assert (designData.getFonts() != null);
        assert (designData.getGenerations() != null);
        assert (designData.getMaps() != null);
        assert (designData.getMenus() != null);
    }

    protected String prepareData(String resource, boolean normalizeXml) throws IOException {
        return JaxbHelper.prepareData(resource, normalizeXml);
    }
}
