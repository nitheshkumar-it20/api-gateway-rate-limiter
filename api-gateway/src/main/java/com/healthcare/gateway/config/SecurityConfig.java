package com.healthcare.gateway.config;

import com.healthcare.gateway.filter.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http.csrf().disable()
                .authorizeExchange()
                .pathMatchers("/auth/**").permitAll()
                .anyExchange().authenticated()
                .and()
                .addFilterBefore(jwtFilter, org.springframework.security.web.server.authentication.AuthenticationWebFilter.class)
                .build();
    }
}
