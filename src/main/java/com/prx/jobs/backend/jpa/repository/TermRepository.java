package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.TermEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * TermRepository
 */
public interface TermRepository extends JpaRepository<TermEntity, UUID> {

    /**
     * @param includeInactive boolean value indicating whether to include inactive status records.
     * @return Optional<List < TermEntity>> containing a list of TermEntity objects.
     */
    @Query("SELECT s FROM TermEntity s WHERE s.active = :includeInactive ")
    Optional<List<TermEntity>> findAllByActive(@Param("includeInactive") boolean includeInactive);
}
