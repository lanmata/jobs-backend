package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.ModeService;
import com.prx.jobs.backend.api.to.ModeListResponse;
import com.prx.jobs.backend.api.to.StatusListResponse;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Mode Controller
 */
@RestController
@RequestMapping("/v1/modes")
public class ModeController {

    /**
     * Mode Service
     */
    private final ModeService modeService;

    /**
     * Constructor
     * @param modeService Mode Service
     */
    public ModeController(ModeService modeService) {
        this.modeService = modeService;
    }

    /**
     * List all modes
     * @param includeInactive Include Inactive
     * @return Mode List Response
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<ModeListResponse> list(@PathParam(value = "includeInactive") boolean includeInactive) {
        return this.modeService.list(includeInactive);
    }
}
