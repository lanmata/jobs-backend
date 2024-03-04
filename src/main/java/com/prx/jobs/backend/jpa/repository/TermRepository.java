package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.TermEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.UUID;

/**
 * TermRepository
 */
public interface TermRepository extends JpaRepositoryImplementation<TermEntity, UUID> {
}
