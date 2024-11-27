package com.tutorlink.student_domain.auth.service;

import com.tutorlink.student_domain.auth.model.dto.request.RegisterUserReq;
import com.tutorlink.student_domain.auth.model.entity.UserEntity;
import com.tutorlink.student_domain.auth.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        BCrypt.checkpw() // used for checking password

    private final UserEntityRepository userEntityRepository;

    public void registerNewUser(RegisterUserReq req) {

        if (req.username().length() < 5 || req.password().length() < 8) {
            throw new RuntimeException("Username and password must contain at least 5 characters");
        }

        boolean exists = userEntityRepository.existsByUsername(req.username());

        if (exists) {
            throw new RuntimeException("Username already exists");
        }
        // TODO: other validations

        var user = UserEntity.builder()
                .email(req.email())
                .username(req.username())
                .password(encoder.encode(req.password()))
                .build();
        userEntityRepository.save(user);
    }
}
