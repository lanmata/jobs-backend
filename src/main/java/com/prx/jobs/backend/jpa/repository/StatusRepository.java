package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.StatusEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository for the StatusEntity
 */
public interface StatusRepository extends JpaRepositoryImplementation<StatusEntity, UUID> {

    /**
     * Find a status by its name
     * @param name the name of the status
     * @return the status
     */
    @Query("SELECT s FROM StatusEntity s WHERE s.active = :includeInactive ")
    Optional<List<StatusEntity>> findAllByActive(@Param("includeInactive") boolean includeInactive);
}
