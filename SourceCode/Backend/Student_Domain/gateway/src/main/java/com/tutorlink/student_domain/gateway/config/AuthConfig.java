package com.tutorlink.student_domain.gateway.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.auth")
public class AuthConfig {
    private boolean checkAuthentication;

    public boolean isCheckAuthentication() {
        return checkAuthentication;
    }

    public void setCheckAuthentication(boolean checkAuthentication) {
        this.checkAuthentication = checkAuthentication;
    }

    @Getter
    @Setter
    private String authenticationserviceurl;

    @Getter
    @Setter
    private String authorizationserviceurl;
}
