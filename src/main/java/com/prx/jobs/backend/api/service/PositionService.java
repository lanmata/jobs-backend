package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.PositionListResponse;
import com.prx.jobs.backend.api.to.PostPositionRequest;
import com.prx.jobs.backend.api.to.SimpleResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import static com.prx.jobs.backend.util.JobsConstants.NOT_IMPLEMENTED;

/**
 * This is the PositionService interface.
 * It provides methods for managing mode records.
 */
public interface PositionService {

    /**
     * The list method returns a list of PositionTO objects.
     *
     * @param includeInactive A boolean value indicating whether to include inactive status records.
     * @return A ResponseEntity containing a list of PositionTO objects.
     */
    default ResponseEntity<PositionListResponse> list(boolean includeInactive) {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED);
    }

    /**
     * The postPosition method creates a new position record.
     *
     * @param request The PostPositionRequest object containing the new position record data.
     * @return A ResponseEntity containing a SimpleResponse object.
     */
    default ResponseEntity<SimpleResponse> save(@RequestBody PostPositionRequest request) {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED);
    }
}
