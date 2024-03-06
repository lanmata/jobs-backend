package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.SourceTypeListResponse;
import org.springframework.http.ResponseEntity;

/**
 * This is the SourceTypeService interface.
 * It provides methods for managing term records.
 */
public interface SourceTypeService {

    /**
     * The list method returns a list of SourceTypeTO objects.
     *
     * @param includeInactive A boolean value indicating whether to include inactive source type records.
     * @return A ResponseEntity containing a list of SourceTypeTO objects.
     */
    default ResponseEntity<SourceTypeListResponse> list(boolean includeInactive) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
