package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.SourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * SourceRepository
 */
public interface SourceRepository extends JpaRepository<SourceEntity, UUID> {

    /**
     * @param includeInactive boolean value indicating whether to include inactive status records.
     * @return Optional<List < SourceEntity>> containing a list of SourceEntity objects.
     */
    @Query("SELECT s FROM SourceEntity s WHERE s.active = :includeInactive ")
    Optional<List<SourceEntity>> findAllByActive(@Param("includeInactive") boolean includeInactive);
}
