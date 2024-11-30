package com.tutorlink.student_domain.auth.service;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.tutorlink.student_domain.auth.model.entity.UserEntity;
import com.tutorlink.student_domain.auth.model.entity.SessionToken;
import com.tutorlink.student_domain.auth.repository.SessionTokenRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SessionTokenService {
    private final SessionTokenRepository sessionTokenRepository;

    public String createSessionToken(UserEntity user) {
        var token = UUID.randomUUID().toString();
        LocalDateTime creation_date = LocalDateTime.now();
        LocalDateTime expiration_date = creation_date.plusMinutes(15);

        var sessionToken = SessionToken.builder()
                .token(token)
                .user(user)
                .createdAt(creation_date)
                .expiresAt(expiration_date)
                .is_valid(true)
                .build();
        sessionTokenRepository.save(sessionToken);
        return token;
    }

    public SessionToken validateSessionToken(String token) throws Exception {
        Optional<SessionToken> opt = sessionTokenRepository.findByToken(token);
        if (opt.isEmpty()) {
            throw new Exception("Token not found: " + token);
        }
        SessionToken sessionToken = opt.get();
        if (sessionToken.getExpiresAt().isBefore(LocalDateTime.now())) {
            sessionToken.set_valid(false);
            sessionTokenRepository.save(sessionToken);
        }
        if (sessionToken.is_valid()) {
            sessionToken.setExpiresAt(LocalDateTime.now().plusMinutes(15));
            sessionTokenRepository.save(sessionToken);
            return sessionToken;
        }
        throw new Exception("Invalid token: " + token);
    }

    public void invalidateSessionToken(String token) {
        Optional<SessionToken> opt = sessionTokenRepository.findByToken(token);
        if (opt.isEmpty()) {
            return;
        }
        SessionToken sessionToken = opt.get();
        sessionToken.set_valid(false);
        sessionTokenRepository.save(sessionToken);
    }

    public void invalidateUserTokens(UserEntity user) {
        Optional<List<SessionToken>> opt = sessionTokenRepository.findByUserId(user.getId());
        if (opt.isEmpty()) {
            return;
        }

        List<SessionToken> sessionTokens = opt.get();
        for (var sessionToken : sessionTokens) {
            sessionToken.set_valid(false);
            sessionTokenRepository.save(sessionToken);
        }
    }
}
