package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.PostEntity;
import com.prx.jobs.backend.util.JobsConstants;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

/**
 * PostRepository
 */
public interface PostRepository extends JpaRepositoryImplementation<PostEntity, UUID> {

    /**
     * Find post entities by post id
     *
     * @param postId the post id
     * @return the optional object[][]
     */
    @Query(nativeQuery = true, value = JobsConstants.POST_CONTENT_DETAIL)
    Optional<Object[][]> findPostEntitiesByPostId(@NotNull @Param("postId") UUID postId);
}
