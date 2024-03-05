package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.PositionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * PositionRepository
 */
public interface PositionRepository extends JpaRepositoryImplementation<PositionEntity, UUID> {

    /**
     * Find all positions by active status
     * @param includeInactive whether to include inactive positions
     * @return the list of positions
     */
    @Query("SELECT s FROM PositionEntity s WHERE s.active = :includeInactive ")
    Optional<List<PositionEntity>> findAllByActive(@Param("includeInactive") boolean includeInactive);
}
