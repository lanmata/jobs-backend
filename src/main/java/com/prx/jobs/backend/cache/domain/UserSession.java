package com.prx.jobs.backend.cache.domain;

import java.util.UUID;

public class UserSession {

    private UUID id;
    private String alias;
    private String token;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserSession() {
        // Default Constructor
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
