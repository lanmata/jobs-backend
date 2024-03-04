package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.PostEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.UUID;

/**
 * PostRepository
 */
public interface PostRepository extends JpaRepositoryImplementation<PostEntity, UUID> {
}
