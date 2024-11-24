package com.prx.jobs.backend.constant;

public enum ManagementAuthKey {
    GRANT_TYPE("grant_type"),
    CLIENT_ID("client_id"),
    USERNAME("username"),
    PASSWORD("password"),
    CLIENT_SECRET("client_secret");

    public final String value;

    ManagementAuthKey(String key) {
        this.value = key;
    }
}
