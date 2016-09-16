package ru.sbt.etsm.drdiff.comparator.logger.file;

import com.vaadin.server.DownloadStream;
import com.vaadin.server.StreamResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by sbt-morozov-kv on 07.09.2016.
 */
public class TemporaryFileDownloadResource extends StreamResource {

    private static final long serialVersionUID = 476307190141362413L;
    private final String filename;
    private final String contentType;

    public TemporaryFileDownloadResource(String fileName, String contentType, File tempFile) throws FileNotFoundException {
        super(new TemporaryFileDownloadResource.FileStreamResource(tempFile), fileName);
        this.filename = fileName;
        this.contentType = contentType;
    }

    public DownloadStream getStream() {
        DownloadStream stream = new DownloadStream(this.getStreamSource().getStream(), this.contentType, this.filename);
        stream.setParameter("Content-Disposition", "attachment;filename=" + this.filename);
        stream.setParameter("Cache-Control", "private,no-cache,no-store");
        stream.setCacheTime(1000L);
        return stream;
    }

    private static class FileStreamResource implements StreamResource.StreamSource {
        private static final long serialVersionUID = 3801605481686085335L;
        private final InputStream inputStream;

        public FileStreamResource(File fileToDownload) throws FileNotFoundException {
            this.inputStream = new DeletingFileInputStream(fileToDownload);
        }

        public InputStream getStream() {
            return this.inputStream;
        }
    }
}
