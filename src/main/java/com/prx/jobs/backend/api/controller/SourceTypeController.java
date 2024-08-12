package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.SourceTypeService;
import com.prx.jobs.backend.api.to.SourceTypeListResponse;
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
@RequestMapping(JOBS_PATH + "/source-types")
public class SourceTypeController {

    /**
     * Company Service
     */
    private final SourceTypeService sourceTypeService;

    /**
     * Constructor
     *
     * @param sourceTypeService Company Service
     */
    public SourceTypeController(SourceTypeService sourceTypeService) {
        this.sourceTypeService = sourceTypeService;
    }

    /**
     * List all companies
     *
     * @param includeInactive Include Inactive
     * @return Company List Response
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<SourceTypeListResponse> list(@PathParam(value = "includeInactive") boolean includeInactive) {
        return this.sourceTypeService.list(includeInactive);
    }
}
