package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.SourceService;
import com.prx.jobs.backend.api.to.SourceListResponse;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;

/**
 * Company Controller
 */
@Validated
@RestController
@RequestMapping(JOBS_PATH + "/sources")
public class SourceController {

    /**
     * Company Service
     */
    private final SourceService sourceService;

    /**
     * Constructor
     *
     * @param sourceService Company Service
     */
    public SourceController(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    /**
     * List all companies
     *
     * @param includeInactive Include Inactive
     * @return Company List Response
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<SourceListResponse> list(@PathParam(value = "includeInactive") boolean includeInactive) {
        return this.sourceService.list(includeInactive);
    }
}
