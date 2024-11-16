package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.AuthService;
import com.prx.jobs.backend.api.to.AuthRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "auth", description = "The authenticate API")
public interface AuthAPi {
    default AuthService getService() {
        return new AuthService() {
        };
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    default ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        return this.getService().access(authRequest);
    }
}
