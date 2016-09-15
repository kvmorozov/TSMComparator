package ru.sbt.etsm.drdiff.comparator.logger.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by sbt-morozov-kv on 07.09.2016.
 */
public class DeletingFileInputStream extends FileInputStream {
    protected File file = null;

    public DeletingFileInputStream(File file) throws FileNotFoundException {
        super(file);
        this.file = file;
    }

    public void close() throws IOException {
        super.close();
        this.file.delete();
    }
}
