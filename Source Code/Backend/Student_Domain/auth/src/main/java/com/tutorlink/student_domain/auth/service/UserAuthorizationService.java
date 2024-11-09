package com.tutorlink.student_domain.auth.service;

import com.tutorlink.student_domain.auth.model.dto.request.UserCredentialsReq;
import com.tutorlink.student_domain.auth.model.entity.Token;
import com.tutorlink.student_domain.auth.model.entity.UserEntity;
import com.tutorlink.student_domain.auth.repository.TokenRepository;
import com.tutorlink.student_domain.auth.repository.UserEntityRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserAuthorizationService {

    private final UserEntityRepository userEntityRepository;
    private final TokenRepository tokenRepository;

    public void createSession(UserCredentialsReq req, HttpServletResponse response) {
        UserEntity user = userEntityRepository.findById(req.userId())
                .orElseThrow(() -> new RuntimeException("could not authorize"));

        //generate unique token
        String token = UUID.randomUUID().toString();

        //save token in the database
        Token userToken = Token.builder()
                .token(token)
                .user(user)
                .build();
        tokenRepository.save(userToken);

        //add token to response headers
        response.addHeader("X-Session-Token", token);
    }

    public void verifyToken(String token) {
        tokenRepository.findById(token)
                .orElseThrow(() -> new RuntimeException("Invalid or expired token"));
    }
}

