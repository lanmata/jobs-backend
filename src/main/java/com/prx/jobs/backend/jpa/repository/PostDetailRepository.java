package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.PostDetailEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.UUID;

/**
 * Repository for PostDetailEntity
 */
public interface PostDetailRepository extends JpaRepositoryImplementation<PostDetailEntity, UUID> {
}
