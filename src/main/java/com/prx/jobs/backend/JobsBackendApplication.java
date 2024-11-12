package com.prx.jobs.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class of the application.
 */
@SpringBootApplication(scanBasePackages =  {"com.prx.jobs.backend", "com.prx.commons.properties", "com.prx.security"})
public class JobsBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobsBackendApplication.class, args);
    }
}
