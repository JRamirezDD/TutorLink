//package com.tutorlink.tutor_domain.gateway.Service;
//
//import com.tutorlink.tutor_domain.gateway.Service.Clients.Client_AuthenticationService;
//import com.tutorlink.tutor_domain.gateway.config.AuthConfig;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.server.ServerWebExchange;
//
//import java.util.Optional;
//
//@Service
//public class GatewayService {
//    @Autowired
//    private WebClient.Builder webClientBuilder;
//
//    @Autowired
//    private AuthConfig authConfig;
//
//    public Optional<Long> getUserIdFromToken(ServerWebExchange exchange) {
//        if (authConfig.isCheckAuthentication()) {
//            String sessionToken = getSessionTokenFromHeader(exchange);
//            if (sessionToken != null) {
//                Optional.of(validateSessionToken(sessionToken));
//            }
//        }
//        return Optional.empty();
//    }
//
//    private String getSessionTokenFromHeader(ServerWebExchange exchange) {
//        String sessionToken = exchange.getRequest().getHeaders().getFirst("Cookie");
//        if (sessionToken != null && sessionToken.contains("SESSIONID=")) {
//            return sessionToken.split("SESSIONID=")[1].split(";")[0];
//        }
//        return null;
//    }
//
//    private Long validateSessionToken(String sessionToken) {
//        // Call authentication service to validate session token and get the user ID
//        return Client_AuthenticationService.validateSession(sessionToken);
//    }
//
//    private Long callAuthenticationService(String token) {
//        WebClient client = webClientBuilder.baseUrl(authConfig.getAuthenticationserviceurl()).build();
//        return client.post()
//                .header(HttpHeaders.CONTENT_TYPE, "application/json")
//                .bodyValue(new TokenRequest(token))
//                .retrieve()
//                .bodyToMono(Long.class)
//                .block();
//    }
//}
