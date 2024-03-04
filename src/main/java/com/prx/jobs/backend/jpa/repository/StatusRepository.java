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
     * Find all statuses by active status
     * @param includeInactive whether to include inactive statuses
     * @return the list of statuses
     */
    @Query("SELECT s FROM StatusEntity s WHERE s.active = :includeInactive ")
    Optional<List<StatusEntity>> findAllByActive(@Param("includeInactive") boolean includeInactive);
}
