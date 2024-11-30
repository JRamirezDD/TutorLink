package com.tutorlink.student_domain.auth.service.clients;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class GoogleApiClient {

    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.google.client-secret}")
    private String clientSecret;

    @Value("${spring.security.oauth2.client.provider.google.user-info-uri}")
    private String userInfoUri;

    private final RestTemplate restTemplate;

    @Autowired
    public GoogleApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Method to retrieve Google user information using the provided OAuth2 token
    public JsonNode getGoogleUserProfile(String accessToken) {
        String url = UriComponentsBuilder.fromHttpUrl(userInfoUri)
                .queryParam("access_token", accessToken)
                .toUriString();

        return restTemplate.getForObject(url, JsonNode.class);
    }

    // Other helper methods if needed, for example, to validate token, etc.
}
