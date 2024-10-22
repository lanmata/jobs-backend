package com.prx.jobs.backend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "prx.security")
public class SecurityProperties {

    private StoreProperties keystore;
    private StoreProperties truststore;
    private ManagementAuthenticatorProperties managementAuthenticator;

    public SecurityProperties() {
        // Default constructor
    }

    public StoreProperties getKeystore() {
        return keystore;
    }

    public void setKeystore(StoreProperties keystore) {
        this.keystore = keystore;
    }

    public StoreProperties getTruststore() {
        return truststore;
    }

    public void setTruststore(StoreProperties truststore) {
        this.truststore = truststore;
    }

    public ManagementAuthenticatorProperties getManagementAuthenticator() {
        return managementAuthenticator;
    }

    public void setManagementAuthenticator(ManagementAuthenticatorProperties managementAuthenticator) {
        this.managementAuthenticator = managementAuthenticator;
    }
}
