package com.prx.jobs.backend.config;

public class ManagementAuthenticatorProperties {
    private String keyAlias;
    private StoreProperties keystore;
    private StoreProperties truststore;

    public String getKeyAlias() {
        return keyAlias;
    }

    public void setKeyAlias(String keyAlias) {
        this.keyAlias = keyAlias;
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
}
