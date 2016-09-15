package ru.sbt.etsm.drdiff.comparator.logger.file;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.sbt.etsm.drdiff.comparator.logger.ILogger;
import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeItem;
import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeTree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by SBT-Morozov-KV on 15.08.2016.
 */
public class TsmFileLogger implements ILogger {

    public static final String PLACEHOLDER_TABS_N = "%TABS%";
    public static final String PLACEHOLDER_TABS_N1 = "%TABSN1%";
    public static final String PLACEHOLDER_TABS_N2 = "%TABSN2%";

    private BufferedWriter bw;

    public TsmFileLogger(File file) throws IOException {
        if (!file.exists())
            file.createNewFile();

        bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));

    }

    @Override
    public void close() throws IOException {
        bw.close();
    }

    public void write(String data) {
        try {
            bw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printItem(int tabLevel, ChangeItem item) throws JsonProcessingException {
        String tabs = new String(new char[tabLevel]).replace("\0", "\t");
        String tabsN1 = tabs + "\t";
        String tabsN2 = tabsN1 + "\t";

        String result = item.getText()
                .replaceAll(PLACEHOLDER_TABS_N, tabs)
                .replaceAll(PLACEHOLDER_TABS_N1, tabsN1)
                .replaceAll(PLACEHOLDER_TABS_N2, tabsN2);

        write(result);

        for (ChangeItem child : item.getChildItems())
            printItem(tabLevel + 1, child);
    }

    private void printTree(ChangeTree tree, boolean printErrors) {
        try {
            printItem(1, tree.getRoot());

            if (printErrors) {
                if (!ChangeTree.getErrors().isEmpty()) {
                    StringBuilder errorsStr = new StringBuilder()
                            .append(System.getProperty("line.separator"))
                            .append("Errors:");

                    for (String error : ChangeTree.getErrors())
                        errorsStr.append(System.getProperty("line.separator")).append("\t").append(error);

                    write(errorsStr.toString());
                }

                write("\n***************************************\n");
            }
        } catch (JsonProcessingException e) {
        }
    }

    @Override
    public void logReport(ChangeTree tree) {
        printTree(tree, false);

        printTree(tree.reverseTree(), true);
    }
}
