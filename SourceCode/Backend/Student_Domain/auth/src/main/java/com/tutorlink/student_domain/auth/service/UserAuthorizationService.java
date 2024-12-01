package com.tutorlink.student_domain.auth.service;

import com.tutorlink.student_domain.auth.model.dto.request.UserCredentialsReq;
import com.tutorlink.student_domain.auth.model.entity.SessionToken;
import com.tutorlink.student_domain.auth.model.entity.UserEntity;
import com.tutorlink.student_domain.auth.repository.SessionTokenRepository;
import com.tutorlink.student_domain.auth.repository.UserEntityRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserAuthorizationService {

    private final UserEntityRepository userEntityRepository;
    private final SessionTokenRepository tokenRepository;

}

