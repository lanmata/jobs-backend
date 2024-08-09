package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.ModeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * ModeRepository
 */
public interface ModeRepository extends JpaRepository<ModeEntity, UUID> {

    /**
     * Find all modes by active status
     *
     * @param includeInactive boolean value indicating whether to include inactive status records.
     * @return Optional<List < ModeEntity>> containing a list of ModeEntity objects.
     */
    @Query("SELECT s FROM ModeEntity s WHERE s.active = :includeInactive ")
    Optional<List<ModeEntity>> findAllByActive(@Param("includeInactive") boolean includeInactive);
}
