package com.tutorlink.student_domain.auth.controller;

import com.tutorlink.student_domain.auth.model.dto.request.UserLoginReq;
import com.tutorlink.student_domain.auth.service.StudentAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class StudentAuthenticationController {

    private final StudentAuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginReq loginRequest) {
        boolean isAuthenticated = authenticationService.authenticateUser(loginRequest);
        return isAuthenticated ? ResponseEntity.ok("Authentication successful") : ResponseEntity.status(401).body("Invalid credentials");
    }
}

