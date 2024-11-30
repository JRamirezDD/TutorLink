package com.tutorlink.student_domain.auth.controller;

import com.tutorlink.student_domain.auth.model.dto.request.UserCredentialsReq;
import com.tutorlink.student_domain.auth.service.UserAuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authorization")
public class
AuthorizationController {

    private final UserAuthorizationService authorizationService;
}

