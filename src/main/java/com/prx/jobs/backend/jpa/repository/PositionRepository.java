package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * PositionRepository
 */
public interface PositionRepository extends JpaRepository<PositionEntity, UUID> {

    /**
     * Find all positions by active status
     *
     * @param includeInactive boolean value indicating whether to include inactive status records.
     * @return Optional<List < PositionEntity>> containing a list of PositionEntity objects.
     */
    @Query("SELECT s FROM PositionEntity s WHERE s.active = :includeInactive ")
    Optional<List<PositionEntity>> findAllByActive(@Param("includeInactive") boolean includeInactive);
}
