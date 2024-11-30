package com.tutorlink.student_domain.auth.service;

import com.tutorlink.student_domain.auth.model.dto.request.RegisterUserReq;
import com.tutorlink.student_domain.auth.model.dto.request.UserLoginReq;
import com.tutorlink.student_domain.auth.model.entity.SessionToken;
import com.tutorlink.student_domain.auth.model.entity.UserEntity;
import com.tutorlink.student_domain.auth.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserEntityRepository userEntityRepository;
    private final SessionTokenService sessionTokenService;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Returns new session token after credentials validation
    public String login(UserLoginReq loginRequest) throws Exception {
        UserEntity user = userEntityRepository.findByUsername(loginRequest.username())
                .orElseThrow(() -> new Exception("Invalid username"));

        if (!passwordEncoder.matches(loginRequest.password(), user.getPassword())) {
            throw new Exception("Invalid password");
        }

        return sessionTokenService.createSessionToken(user);
    }

    public UserEntity register(RegisterUserReq req) throws Exception {

        if (req.password().length() < 8) {
            throw new Exception("Password must contain at least 8 characters");
        }

        if (userEntityRepository.findByUsername(req.username()).isPresent()) {
            throw new Exception("Username already exists");
        }

        if (userEntityRepository.findByEmail(req.email()).isPresent()) {
            throw new Exception("Email already exists");
        }

        var user = UserEntity.builder()
                .email(req.email())
                .username(req.username())
                .password(passwordEncoder.encode(req.password()))
                .build();
        return userEntityRepository.save(user);
    }

    public SessionToken authenticate(String token) throws Exception {
        return sessionTokenService.validateSessionToken(token);
    }

    public void invalidateSessionToken(String token) throws Exception {
        sessionTokenService.invalidateSessionToken(token);
    }
}




