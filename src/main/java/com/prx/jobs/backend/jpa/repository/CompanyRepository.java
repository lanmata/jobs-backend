package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Repository for CompanyEntity
 */
public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
}
