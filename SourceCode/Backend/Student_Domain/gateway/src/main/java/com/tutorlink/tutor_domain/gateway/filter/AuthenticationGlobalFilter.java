package com.tutorlink.tutor_domain.gateway.filter;

import com.tutorlink.tutor_domain.gateway.Service.Clients.Client_AuthenticationService;
import com.tutorlink.tutor_domain.gateway.config.AuthConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthenticationGlobalFilter implements GlobalFilter {

    private final AuthConfig authConfig;
    private final Client_AuthenticationService authenticationServiceFeignClient;


    @Autowired
    public AuthenticationGlobalFilter(@Lazy Client_AuthenticationService authenticationServiceFeignClient, AuthConfig authConfig) {
        this.authenticationServiceFeignClient = authenticationServiceFeignClient;
        this.authConfig = authConfig;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // If authentication is disabled, skip the filter logic
        if (!authConfig.isCheckAuthentication()) {
            return chain.filter(exchange);  // Skip authentication checks
        }

        // Allow requests to login, google-login, and register to pass without authentication
        String path = exchange.getRequest().getURI().getPath();
        if (path.startsWith("/auth/login") || path.startsWith("/auth/google-login") || path.startsWith("/auth/register")) {
            return chain.filter(exchange);
        }

        // Get the SESSIONTOKEN cookie directly from the request
        String sessionToken = exchange.getRequest().getCookies().getFirst("SESSIONTOKEN") != null ?
                exchange.getRequest().getCookies().getFirst("SESSIONTOKEN").getValue() : null;

        // If no session token, reject the request
        if (sessionToken == null || sessionToken.isEmpty()) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        // Validate the session token via Feign client
        return authenticationServiceFeignClient.validateSession(sessionToken)
                .flatMap(isValid -> {
                    if (isValid) {
                        return chain.filter(exchange);
                    } else {
                        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                        return exchange.getResponse().setComplete();
                    }
                }).onErrorResume(e -> {
                    exchange.getResponse().setStatusCode(HttpStatus.SERVICE_UNAVAILABLE);
                    return exchange.getResponse().setComplete();
                });
    }
}
