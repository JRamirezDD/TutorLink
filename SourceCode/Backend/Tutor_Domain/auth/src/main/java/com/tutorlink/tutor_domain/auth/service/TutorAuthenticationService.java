package com.tutorlink.tutor_domain.auth.service;


import com.tutorlink.tutor_domain.auth.model.dto.request.TutorLoginReq;
import com.tutorlink.tutor_domain.auth.repository.CredentialsRepository;
import com.tutorlink.tutor_domain.auth.service.TutorAuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TutorAuthenticationService {

    private final CredentialsRepository credentialsRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean authenticateTutor(TutorLoginReq loginReq) {
        var tutorCredentials = credentialsRepository.findByUsername(loginReq.username())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        return passwordEncoder.matches(loginReq.password(), tutorCredentials.getPassword());
    }
}

