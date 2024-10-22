package com.prx.jobs.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The main class of the application.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class JobsBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobsBackendApplication.class, args);
    }
}
