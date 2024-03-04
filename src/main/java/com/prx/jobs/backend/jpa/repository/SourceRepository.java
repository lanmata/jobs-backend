package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.SourceEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.UUID;

/**
 * SourceRepository
 */
public interface SourceRepository extends JpaRepositoryImplementation<SourceEntity, UUID> {
}
