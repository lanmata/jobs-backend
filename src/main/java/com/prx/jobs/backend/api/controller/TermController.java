package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.TermService;
import com.prx.jobs.backend.api.to.TermListResponse;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;

/**
 * Term Controller
 */
@RestController
@RequestMapping(JOBS_PATH + "/terms")
public class TermController {

    /**
     * Term Service
     */
    private final TermService termService;

    /**
     * Constructor
     *
     * @param termService Term Service
     */
    public TermController(TermService termService) {
        this.termService = termService;
    }

    /**
     * List all terms
     *
     * @param includeInactive Include Inactive
     * @return Term List Response
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<TermListResponse> list(@PathParam(value = "includeInactive") boolean includeInactive) {
        return this.termService.list(includeInactive);
    }
}
