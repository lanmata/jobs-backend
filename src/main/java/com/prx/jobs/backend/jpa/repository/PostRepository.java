package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.PostEntity;
import com.prx.jobs.backend.util.JobsConstants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * PostRepository
 */
public interface PostRepository extends JpaRepository<PostEntity, UUID> {

    /**
     * The findPostEntitiesByPostId method returns a list of post entities.
     *
     * @return A list of post entities.
     */
    @Query(nativeQuery = true, value = JobsConstants.POST_CONTENT_DETAIL)
    Optional<List<Object[][]>> findPostEntities();
}
