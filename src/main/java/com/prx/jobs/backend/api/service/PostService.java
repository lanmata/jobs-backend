package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.GetPostResponse;
import com.prx.jobs.backend.api.to.PostContentTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

/**
 * This is the PostService interface.
 * It provides methods for managing post records.
 */
public interface PostService {

    /**
     * Finds post content by post id.
     *
     * @return ResponseEntity<List<PostContentTO>>.
     */
    default ResponseEntity<List<PostContentTO>> findPostContent() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Finds post content by post id.
     *
     * @param uuid The post id.
     * @return ResponseEntity<GetPostResponse>.
     */
    default ResponseEntity<GetPostResponse> findPostContentByPostId(UUID uuid) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
