package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.TermEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * TermRepository
 */
public interface TermRepository extends JpaRepositoryImplementation<TermEntity, UUID> {

    /**
     * Find all terms by active status
     * @param includeInactive whether to include inactive terms
     * @return the list of terms
     */
    @Query("SELECT s FROM TermEntity s WHERE s.active = :includeInactive ")
    Optional<List<TermEntity>> findAllByActive(@Param("includeInactive") boolean includeInactive);
}
