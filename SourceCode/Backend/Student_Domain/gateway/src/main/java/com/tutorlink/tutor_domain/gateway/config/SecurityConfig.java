package com.tutorlink.tutor_domain.gateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.server.WebFilter;


import java.util.Arrays;

@Configuration
@EnableWebFluxSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Autowired
    private AuthConfig authConfig;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        // Set up CORS filter and disable CSRF
        http.addFilterBefore(corsWebFilter(), SecurityWebFiltersOrder.CORS)  // Add the CorsFilter before security filters
                .authorizeExchange(auth -> {
                    // Permit /gateway/authentication/** paths without authentication
                    auth.pathMatchers("/gateway/authentication/**").permitAll();

                    // Allow all other paths on the gateway if authentication is disabled
                    if (!authConfig.isCheckAuthentication()) {
                        auth.pathMatchers("/gateway/**").permitAll();  // Allow all requests on gateway paths if authentication is disabled
                    } else if (authConfig.isCheckAuthentication()) {
                        // Protect other /gateway/** paths with authentication
                        auth.pathMatchers("/gateway/**").authenticated();
                    }

                    // Any other requests (including those not matched) are allowed
                    auth.anyExchange().permitAll();
                })
                .csrf().disable();  // Disabling CSRF for the Gateway, assuming you're using token-based auth or similar

        return http.build();
    }

    @Bean
    public WebFilter corsWebFilter() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:80"));  // Frontend URL
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);

        CorsConfigurationSource corsConfigurationSource = exchange -> configuration;

        return new CorsWebFilter(corsConfigurationSource);  // Use CorsWebFilter with CorsConfigurationSource

    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // To allow accessing monitoring endpoints without authentication
        return (web) -> web.ignoring().requestMatchers("/swagger-ui/**", "/actuator/**");
    }
}

