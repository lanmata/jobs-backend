package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.PositionService;
import com.prx.jobs.backend.api.to.PositionListResponse;
import com.prx.jobs.backend.api.to.PostPositionRequest;
import com.prx.jobs.backend.api.to.SimpleResponse;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Position Controller
 */
@RestController
@RequestMapping("/v1/positions")
public class PositionController {


    /**
     * Position Service
     */
    private final PositionService positionService;

    /**
     * Constructor
     *
     * @param positionService Position Service
     */
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    /**
     * List all positions
     *
     * @param includeInactive Include Inactive
     * @return Position List Response
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<PositionListResponse> list(@PathParam(value = "includeInactive") boolean includeInactive) {
        return this.positionService.list(includeInactive);
    }

    /**
     * Post a position
     *
     * @param request Post Position Request
     * @return Simple Response
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<SimpleResponse> post(@RequestBody PostPositionRequest request) {
        return this.positionService.save(request);
    }
}
