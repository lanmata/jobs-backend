package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.AuthService;
import com.prx.jobs.backend.api.to.AuthRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;

@RestController
@RequestMapping(JOBS_PATH + "/auth")
public class AuthApiController implements AuthAPi {

    private final AuthService authService;

    public AuthApiController(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ResponseEntity<String> login(AuthRequest authRequest) {
        return authService.access(authRequest);
    }
}
