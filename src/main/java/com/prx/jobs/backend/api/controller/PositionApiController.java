package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.PositionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;

/**
 * Position Controller
 */
@RestController
@RequestMapping(JOBS_PATH + "/positions")
public class PositionApiController implements PositionApi {

    /**
     * Position Service
     */
    private final PositionService positionService;

    /**
     * Constructor
     *
     * @param positionService Position Service
     */
    public PositionApiController(PositionService positionService) {
        this.positionService = positionService;
    }

    @Override
    public PositionService getService() {
        return this.positionService;
    }
}
