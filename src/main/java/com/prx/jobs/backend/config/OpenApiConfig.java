package com.prx.jobs.backend.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class OpenApiConfig {

    private final static Logger LOGGER = LogManager.getLogger(OpenApiConfig.class);

    @Value("${swagger.api-info.title}")
    private String title;

    @Value("${swagger.api-info.version}")
    private String version;

    @Bean
    @Profile("!prod")
    public GroupedOpenApi actuatorApi(OpenApiCustomizer actuatorOpenApiCustomizer,
                                      OperationCustomizer actuatorCustomizer,
                                      WebEndpointProperties endpointProperties,
                                      @Value("${springdoc.version}") String appVersion) {
        LOGGER.info("Base path : {} ", endpointProperties.getBasePath());
        return GroupedOpenApi.builder()
                .group("Actuator")
                .pathsToMatch(endpointProperties.getBasePath() + "/swagger-ui/**")
                .pathsToMatch(endpointProperties.getBasePath() + "/v3/api-docs/**")
                .pathsToMatch(endpointProperties.getBasePath() + "/swagger-resources/**")
                .pathsToMatch(endpointProperties.getBasePath() + "/swagger-resources")
                .addOpenApiCustomizer(actuatorOpenApiCustomizer)
                .addOpenApiCustomizer(openApi -> openApi.info(new Info().title("Actuator API").version(appVersion)))
                .addOperationCustomizer(actuatorCustomizer)
                .pathsToExclude("/health/*")
                .build();
    }

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title(title).version(version))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(
                        new Components()
                                .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT"))
                );
    }
}
