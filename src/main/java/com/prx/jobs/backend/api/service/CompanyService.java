package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.CompanyListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * This is the CompanyService interface.
 * It provides methods for managing term records.
 */
public interface CompanyService {

    /**
     * The list method returns a list of CompanyTO objects.
     *
     * @param includeInactive A boolean value indicating whether to include inactive status records.
     * @return A ResponseEntity containing a list of CompanyTO objects.
     */
    default ResponseEntity<CompanyListResponse> list(boolean includeInactive) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
