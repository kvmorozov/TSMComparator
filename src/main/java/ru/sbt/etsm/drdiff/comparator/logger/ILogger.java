package ru.sbt.etsm.drdiff.comparator.logger;

import ru.sbt.etsm.drdiff.comparator.logger.file.TsmFileLogger;
import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeTree;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by sbt-morozov-kv on 06.09.2016.
 */
public interface ILogger extends Closeable {

    void logReport(ChangeTree tree);

    static ILogger getLogger() throws IOException {
        return new TsmFileLogger(new File("E:\\ETSM\\log\\log" + (new Date()).getTime() + ".txt"));
    }

}
