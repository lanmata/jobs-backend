package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.AuthService;
import com.prx.jobs.backend.api.to.AuthRequest;
import com.prx.jobs.backend.api.to.AuthResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import static com.prx.jobs.backend.util.JobsConstants.BACKBONE_SESSION_TOKEN;

@Tag(name = "auth", description = "The authenticate API")
public interface AuthAPi {
    default AuthService getService() {
        return new AuthService() {
        };
    }

    @PostMapping(path = "/token", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    default ResponseEntity<AuthResponse> accessToken(@RequestHeader(BACKBONE_SESSION_TOKEN) String sessionTokenBkd, @RequestBody AuthRequest authRequest) {
        return this.getService().token(authRequest);
    }

}
