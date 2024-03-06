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

    @Query("SELECT s FROM SourceTypeEntity s WHERE s.active = :includeInactive ")
    Optional<List<SourceTypeEntity>> findAllByActive(@Param("includeInactive") boolean includeInactive);
}
