package com.prx.jobs.backend.config.converter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "jwt.auth.converter")
public class JwtConverterProperties {

    private String resourceId;
    private String principalAttribute;

    public JwtConverterProperties() {
        // Default constructor
    }

    public String getPrincipalAttribute() {
        return principalAttribute;
    }

    public void setPrincipalAttribute(String principalAttribute) {
        this.principalAttribute = principalAttribute;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }
}
