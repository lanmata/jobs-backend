package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository for CompanyEntity
 */
public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {

    /**
     * Find all companies by active status
     * @param includeInactive whether to include inactive companies
     * @return the list of companies
     */
    @Query("SELECT s FROM CompanyEntity s WHERE s.active = :includeInactive ")
    Optional<List<CompanyEntity>> findAllByActive(@Param("includeInactive") boolean includeInactive);
}
