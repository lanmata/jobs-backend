package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.SourceTypeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * SourceTypeRepository
 */
public interface SourceTypeRepository extends JpaRepositoryImplementation<SourceTypeEntity, UUID> {

    /**
     * @param includeInactive boolean value indicating whether to include inactive status records.
     * @return Optional<List<SourceTypeEntity>> containing a list of SourceTypeEntity objects.
     */
    @Query("SELECT s FROM SourceTypeEntity s WHERE s.active = :includeInactive ")
    Optional<List<SourceTypeEntity>> findAllByActive(@Param("includeInactive") boolean includeInactive);
}
