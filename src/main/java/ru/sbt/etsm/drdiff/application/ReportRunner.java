package ru.sbt.etsm.drdiff.application;

import com.google.common.io.Files;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.xml.sax.SAXException;
import ru.sbt.etsm.drdiff.comparator.TsmComparator;
import ru.sbt.etsm.drdiff.comparator.logger.db.ChangeEntryRepository;
import ru.sbt.etsm.drdiff.comparator.logger.db.LocalH2Config;
import ru.sbt.etsm.drdiff.comparator.logger.db.TsmDbLogger;
import ru.sbt.etsm.drdiff.comparator.logger.file.ExcelGenerator;
import ru.sbt.etsm.drdiff.comparator.logger.file.TsmFileLogger;
import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeTree;
import ru.sbt.etsm.drdiff.generated.DesignReport;
import ru.sbt.etsm.drdiff.utils.jaxb.JaxbHelper;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

/**
 * Created by sbt-morozov-kv on 07.10.2016.
 */
public class ReportRunner {

    private String inputFile1;
    private String inputFile2;
    private String outputDir;

    private ChangeTree changes;

    void init(String inputFile1, String inputFile2, String outputDir) throws IOException, JAXBException, SAXException {
        this.inputFile1 = inputFile1;
        this.inputFile2 = inputFile2;
        this.outputDir = outputDir;

        DesignReport oldReport = JaxbHelper.unmarshal(DesignReport.class, JaxbHelper.prepareDataFromFile(inputFile1, true), false);
        DesignReport newReport = JaxbHelper.unmarshal(DesignReport.class, JaxbHelper.prepareDataFromFile(inputFile2, true), false);

        changes = TsmComparator.compare(oldReport, newReport);
    }

    void generateFullReport() throws IOException {
        try (TsmFileLogger logger = new TsmFileLogger(new File(outputDir + "/report_full.txt"))) {
            logger.logReport(changes);
        }

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("ru.sbt.etsm.drdiff.comparator.logger.db");
        ctx.register(LocalH2Config.class);
        ctx.refresh();
        TsmDbLogger dbLogger = ctx.getBean(TsmDbLogger.class);
        dbLogger.logReport(changes);
        ChangeEntryRepository repository = ctx.getBean(ChangeEntryRepository.class);
        File file = (new ExcelGenerator(repository.findAll(ChangeEntryRepository.DEFAULT_SORT))).generateFile();
        Files.move(file, new File(outputDir + "/report_short.xls"));
    }
}
