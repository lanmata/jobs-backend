package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.ModeEntity;
import com.prx.jobs.backend.jpa.entity.TermEntity;
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
     * @param includeInactive whether to include inactive modes
     * @return the list of modes
     */
    @Query("SELECT s FROM ModeEntity s WHERE s.active = :includeInactive ")
    Optional<List<ModeEntity>> findAllByActive(@Param("includeInactive") boolean includeInactive);
}
