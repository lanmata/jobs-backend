package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.SourceTypeEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.UUID;

/**
 * SourceTypeRepository
 */
public interface SourceTypeRepository extends JpaRepositoryImplementation<SourceTypeEntity, UUID> {
}
