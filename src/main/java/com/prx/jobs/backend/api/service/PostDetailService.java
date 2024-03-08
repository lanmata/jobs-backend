package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.PostDetailTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This is the PostDetailService interface.
 * It provides methods for managing post records.
 */
public interface PostDetailService {

    /**
     * Finds post content by post id.
     *
     * @param postId The post id to search for.
     * @return ResponseEntity<List<PostDetailTO>>.
     */
    default ResponseEntity<List<PostDetailTO>> findPostDetailByPostId(UUID postId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    default Optional<List<PostDetailTO>> findPostDetailTOByPostId(UUID postId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
