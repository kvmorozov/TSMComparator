package ru.sbt.etsm.drdiff.comparator.logger.db;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sbt-morozov-kv on 23.06.2016.
 */

public interface ChangeEntryRepository extends JpaRepository<ChangeEntry, Long> {

    public static final Sort DEFAULT_SORT = new Sort(Sort.Direction.ASC, "place")
            .and(new Sort(Sort.Direction.ASC, "change"))
            .and(new Sort(Sort.Direction.ASC, "activator"))
            .and(new Sort(Sort.Direction.ASC, "role"));
}
