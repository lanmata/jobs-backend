package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.AuthRequest;
import com.prx.jobs.backend.client.BackboneClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final BackboneClient backboneClient;

    public AuthServiceImpl(BackboneClient backboneClient) {
        this.backboneClient = backboneClient;
    }

    @Override
    public ResponseEntity<String> access(AuthRequest authRequest) {
        return ResponseEntity.ok(backboneClient.token(authRequest));
    }
}
