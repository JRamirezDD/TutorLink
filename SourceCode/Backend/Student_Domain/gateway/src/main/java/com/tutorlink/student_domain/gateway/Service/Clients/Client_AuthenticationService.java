package com.tutorlink.student_domain.gateway.Service.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import reactor.core.publisher.Mono;

@FeignClient(name = "authentication-service", url = "${spring.auth.authenticationserviceurl}")
public interface Client_AuthenticationService {
    @GetMapping("/auth/validate-session")
    Mono<Boolean> validateSession(@RequestHeader("SESSIONTOKEN") String sessionToken);
}
