package com.prx.jobs.backend.config.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class JwtConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    private static final  String RESOURCE_ACCESS_STRING = "resource_access";
    private static final String ROLE_PREFIX = "ROLE_";
    private static final String ROLE_KEY = "roles";

    private final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter;

    private final JwtConverterProperties jwtConverterProperties;

    public JwtConverter(JwtConverterProperties jwtConverterProperties) {
        this.jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        this.jwtConverterProperties = jwtConverterProperties;
    }

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Collection<GrantedAuthority> authorityCollection = Stream.concat(
                jwtGrantedAuthoritiesConverter.convert(jwt).stream(),
                extractResourceRoles(jwt).stream()).collect(Collectors.toSet());
        return new JwtAuthenticationToken(jwt, authorityCollection, getPrincipalClaimName(jwt));
    }

    private String getPrincipalClaimName(Jwt jwt) {
        String claimName = JwtClaimNames.SUB;
        if(Objects.nonNull(jwtConverterProperties.getPrincipalAttribute())) {
            claimName = jwtConverterProperties.getPrincipalAttribute();
        }
        return jwt.getClaim(claimName);
    }

    private Collection<? extends GrantedAuthority> extractResourceRoles(Jwt jwt) {
        Map<String, Object> resourceAccess = jwt.getClaim(RESOURCE_ACCESS_STRING);
        Map<String, Object> resource= (Map<String, Object>) resourceAccess.get(jwtConverterProperties.getResourceId());
        Collection<String> resourceRoles = (Collection<String>) resource.get(ROLE_KEY);

        if(Objects.isNull(resourceAccess) || Objects.isNull(resource )) {
            return Set.of();
        }

        return resourceRoles.stream().map(role -> new SimpleGrantedAuthority(ROLE_PREFIX.concat(role))).collect(Collectors.toSet());
    }
}
