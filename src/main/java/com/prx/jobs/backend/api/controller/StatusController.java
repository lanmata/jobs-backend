package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.StatusService;
import com.prx.jobs.backend.api.to.StatusListResponse;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;

/**
 * Status Controller
 */
@RestController
@RequestMapping(JOBS_PATH + "/status")
public class StatusController {

    /**
     * Status Service
     */
    private final StatusService statusService;

    /**
     * Constructor
     *
     * @param statusService boolean value
     */
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    /**
     * List all statuses
     *
     * @param includeInactive Include Inactive
     * @return Status List Response
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<StatusListResponse> list(@PathParam(value = "includeInactive") boolean includeInactive) {
        return this.statusService.list(includeInactive);
    }
}
