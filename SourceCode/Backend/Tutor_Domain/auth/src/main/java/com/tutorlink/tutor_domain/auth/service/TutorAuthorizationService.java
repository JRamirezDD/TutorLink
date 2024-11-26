package com.tutorlink.tutor_domain.auth.service;

import com.tutorlink.tutor_domain.auth.model.dto.request.TutorCredentialsReq;
import com.tutorlink.tutor_domain.auth.model.entity.Token;
import com.tutorlink.tutor_domain.auth.repository.TokenRepository;
import com.tutorlink.tutor_domain.auth.repository.CredentialsRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TutorAuthorizationService {

    private final CredentialsRepository credentialsRepository;
    private final TokenRepository tokenRepository;

    public void createSession(TutorCredentialsReq req, HttpServletResponse response) {
        var tutor = credentialsRepository.findByUsername(req.username())
                .orElseThrow(() -> new RuntimeException("could not authorize"));

        String token = UUID.randomUUID().toString();

        Token tutorToken = Token.builder()
                .token(token)
                .tutor(tutor)
                .build();
        tokenRepository.save(tutorToken);

        response.addHeader("X-Session-Token", token);
    }

    public void verifyToken(String token) {
        tokenRepository.findById(token)
                .orElseThrow(() -> new RuntimeException("Invalid or expired token"));
    }
}

