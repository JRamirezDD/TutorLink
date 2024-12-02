package com.tutorlink.student_domain.auth.service;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.tutorlink.student_domain.auth.model.entity.UserEntity;
import com.tutorlink.student_domain.auth.repository.UserEntityRepository;
import com.tutorlink.student_domain.auth.service.clients.GoogleApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoogleOAuthService {
        private final SessionTokenService sessionTokenService;
        private final GoogleApiClient googleApiClient;
        private final UserEntityRepository userEntityRepository;


        public String login(String googleToken) {JsonNode googleUserProfile = googleApiClient.getGoogleUserProfile(googleToken);
                String googleId = googleUserProfile.get("id").asText();
                String email = googleUserProfile.get("email").asText();
                String name = googleUserProfile.get("name").asText();

                Optional<UserEntity> email_opt = userEntityRepository.findByEmail(email);
                Optional<UserEntity> google_opt = userEntityRepository.findByGoogleId(googleId);

                UserEntity userEntity = google_opt.orElse(null);
                if (userEntity == null){
                        if (email_opt.isPresent()){
                                userEntity = email_opt.get();
                                userEntity.setGoogleId(googleId);
                                userEntityRepository.save(userEntity);
                        }
                        else {
                                // new user is created
                                userEntity = new UserEntity();
                                userEntity.setGoogleId(googleId);
                                userEntity.setEmail(email);
                                userEntity.setUsername(name);
                                userEntityRepository.save(userEntity);
                        }
                }

                return sessionTokenService.createSessionToken(userEntity);
        }
}
