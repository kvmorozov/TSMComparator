package ru.sbt.etsm.drdiff.comparator.logger.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbt.etsm.drdiff.comparator.logger.ILogger;
import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeTree;
import ru.sbt.etsm.drdiff.comparator.logger.model.ChangeVector;

import java.io.IOException;

/**
 * Created by sbt-morozov-kv on 06.09.2016.
 */
@Component
public class TsmDbLogger implements ILogger {

    @Autowired
    private ChangeEntryRepository repository;

    @Override
    public void logReport(ChangeTree tree) {
        repository.deleteAll();

        for (ChangeVector vector : tree.getFlatVectors())
            repository.save(vector.getEntry());
    }

    @Override
    public void close() throws IOException {

    }
}
