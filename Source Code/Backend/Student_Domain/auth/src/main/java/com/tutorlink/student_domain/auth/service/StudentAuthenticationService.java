package com.tutorlink.student_domain.auth.service;

import com.tutorlink.student_domain.auth.model.dto.request.UserLoginReq;
import com.tutorlink.student_domain.auth.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentAuthenticationService {

    private final UserEntityRepository userEntityRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean authenticateUser(UserLoginReq loginRequest) {
        var user = userEntityRepository.findById(loginRequest.userId())
                .orElseThrow(() -> new RuntimeException("Invalid ID or password"));

        return passwordEncoder.matches(loginRequest.password(), user.getPassword());
    }
}




