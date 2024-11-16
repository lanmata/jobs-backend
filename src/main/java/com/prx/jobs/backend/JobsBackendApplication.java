package com.prx.jobs.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * The main class of the application.
 */
@EnableFeignClients(basePackages = "com.prx.jobs.backend.client")
@SpringBootApplication(scanBasePackages =  {"com.prx.jobs.backend", "com.prx.commons.properties", "com.prx.security"})
public class JobsBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobsBackendApplication.class, args);
    }
}
