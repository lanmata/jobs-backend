package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.PositionEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.UUID;

/**
 * PositionRepository
 */
public interface PositionRepository extends JpaRepositoryImplementation<PositionEntity, UUID> {
}
