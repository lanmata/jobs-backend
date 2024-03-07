package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.PostContentTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

/**
 * This is the PostService interface.
 * It provides methods for managing post records.
 */
public interface PostService {

    /**
     * The findPostContentByPostId method returns a PostContentEntity object.
     *
     * @param postId A UUID value representing the post identifier.
     * @return A ResponseEntity containing a PostContentEntity object.
     */
    default ResponseEntity<PostContentTO> findPostContentByPostId(UUID postId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
