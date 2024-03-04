package com.prx.jobs.backend.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * This is the DataBaseConfig class.
 * It is annotated with @Configuration to indicate that it is a configuration class.
 * It uses @EntityScan to specify the base packages to scan for entity classes.
 * It uses @EnableJpaRepositories to specify the base packages to scan for JPA repositories.
 */
@Configuration
@EntityScan(basePackages = {"com.prx.jobs.backend.jpa.entity"})
@EnableJpaRepositories(basePackages = {"com.prx.jobs.backend.jpa.repository"})
public class DataBaseConfig {
}
