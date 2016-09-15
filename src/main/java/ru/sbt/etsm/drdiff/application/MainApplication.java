package ru.sbt.etsm.drdiff.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.sbt.etsm.drdiff.comparator.logger.db.ChangeEntryRepository;

/**
 * Created by sbt-morozov-kv on 22.06.2016.
 */

@SpringBootApplication(scanBasePackages = "ru.sbt.etsm.drdiff.comparator.logger.db," +
        "ru.sbt.etsm.drdiff.application")
@EnableJpaRepositories(basePackageClasses = ChangeEntryRepository.class)
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}