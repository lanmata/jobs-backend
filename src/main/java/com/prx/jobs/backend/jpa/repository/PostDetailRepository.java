package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.PostDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository for PostDetailEntity
 */
public interface PostDetailRepository extends JpaRepository<PostDetailEntity, UUID> {

    /**
     * Finds post detail entities by post id.
     *
     * @param postId The post id to search for.
     * @return Optional<List<PostDetailEntity>>.
     */
    @Query("SELECT p FROM PostDetailEntity p WHERE p.post.id = :postId")
    Optional<List<PostDetailEntity>> findPostDetailEntitiesByPostId(UUID postId);
}
