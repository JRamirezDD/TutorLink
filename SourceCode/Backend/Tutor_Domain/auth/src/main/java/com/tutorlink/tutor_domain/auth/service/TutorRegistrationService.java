package com.tutorlink.tutor_domain.auth.service;

import com.tutorlink.tutor_domain.auth.model.dto.request.TutorRegistrationReq;
import com.tutorlink.tutor_domain.auth.model.dto.response.TutorRegistrationResp;
import com.tutorlink.tutor_domain.auth.model.entity.TutorEntity;
import com.tutorlink.tutor_domain.auth.repository.CredentialsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TutorRegistrationService {

    private final CredentialsRepository credentialsRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public TutorRegistrationResp registerNewTutor(TutorRegistrationReq req) {
        //check if a tutor with the same username already exists
        if (credentialsRepository.findByUsername(req.username()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        //encrypt password and create a new tutor
        TutorEntity tutor = TutorEntity.builder()
                .username(req.username())
                .password(passwordEncoder.encode(req.password()))
                .email(req.email())
                .build();

        credentialsRepository.save(tutor);

        return new TutorRegistrationResp(tutor.getId(), tutor.getUsername(), tutor.getEmail(), "Registration successful");
    }
}

