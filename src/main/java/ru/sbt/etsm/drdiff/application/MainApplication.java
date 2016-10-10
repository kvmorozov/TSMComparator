package ru.sbt.etsm.drdiff.application;

import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created by sbt-morozov-kv on 22.06.2016.
 */

public class MainApplication {

    public static void main(String[] args) throws IOException, JAXBException, SAXException {
        if (args.length != 3) {
            System.err.println("Должно быть 3 аргумента: файл1, файл2, папка для отчёта");
            System.exit(-1);
        }

        String inputFile1 = args[0];
        String inputFile2 = args[1];
        String outputDir = args[2];

        ReportRunner runner = new ReportRunner();
        runner.init(inputFile1, inputFile2, outputDir);
        runner.generateFullReport();

        System.exit(0);
    }
}