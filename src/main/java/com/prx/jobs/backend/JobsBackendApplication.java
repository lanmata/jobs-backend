package com.prx.jobs.backend;

import com.prx.jobs.backend.config.converter.JwtConverterProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The main class of the application.
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties(JwtConverterProperties.class)
public class JobsBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobsBackendApplication.class, args);
    }
}
