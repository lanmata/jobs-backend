package com.prx.jobs.backend.config;

import com.prx.jobs.backend.config.converter.JwtConverter;
import com.prx.jobs.backend.config.converter.JwtConverterProperties;
import com.prx.jobs.backend.exceptions.CertException;
import com.prx.jobs.backend.util.KeyStoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;

import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;
import static org.springframework.http.HttpMethod.GET;

/**
 * Security configuration class for the application.
 */
@Configuration
@EnableWebSecurity
@EnableConfigurationProperties({JwtConverterProperties.class, SecurityProperties.class})
public class SecurityConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    private static final String[] SWAGGER_LIST = {
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/**",
            "/swagger-resources/**",
            "/swagger-resources"
    };

    @Value("${app.clientRoles}")
    private String[] clientRoleList;

    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
    private String jwkSetUri;

    private final JwtConverter jwtConverter;

    private final SecurityProperties securityProperties;

    private final KeyStoreUtil keyStoreUtil = new KeyStoreUtil();

    /**
     * Constructor for SecurityConfig.
     */
    public SecurityConfig(JwtConverter jwtConverter, SecurityProperties securityProperties) {
        this.jwtConverter = jwtConverter;
        this.securityProperties = securityProperties;
    }

    /**
     * Configures the security filter chain.
     *
     * @param http the HttpSecurity to configure
     * @return the configured SecurityFilterChain
     * @throws Exception if an error occurs while configuring the security filter chain
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        LOGGER.info("Loading SecurityFilterChain");
        http.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(SWAGGER_LIST).permitAll()
                        .requestMatchers(GET, JOBS_PATH.concat("/**")).hasAnyRole(clientRoleList)
                        .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtConverter)));

        http.sessionManagement(sessionManagement -> sessionManagement
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtConverter)));

        LOGGER.info("Loaded SecurityFilterChain::");
        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder(RestTemplate restTemplate) {
        return NimbusJwtDecoder.withJwkSetUri(this.jwkSetUri).restOperations(restTemplate).build();
    }

    @Bean
    public RestTemplate getRestTemplate() throws CertException {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        return restTemplateBuilder.setSslBundle(keyStoreUtil.getSslBundle(securityProperties)).build();
    }
}
