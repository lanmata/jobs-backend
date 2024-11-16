package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.AuthRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Service interface for handling authentication-related operations.
 */
public interface AuthService {

    /**
     * Default method to handle access requests.
     *
     * @param authRequest the authentication request containing user credentials
     * @return a ResponseEntity with HTTP status NOT_IMPLEMENTED
     */
    default ResponseEntity<String> access(AuthRequest authRequest) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
