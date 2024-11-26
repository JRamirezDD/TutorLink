package com.tutorlink.tutor_domain.auth.controller;


import com.tutorlink.tutor_domain.auth.model.dto.request.TutorLoginReq;
import com.tutorlink.tutor_domain.auth.service.TutorAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutor/auth")
@RequiredArgsConstructor
public class TutorAuthenticationController {

    private final TutorAuthenticationService tutorAuthenticationService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody TutorLoginReq loginReq) {
        boolean isAuthenticated = tutorAuthenticationService.authenticateTutor(loginReq);
        return isAuthenticated ? ResponseEntity.ok("Authentication successful") : ResponseEntity.status(401).body("Invalid credentials");
    }
}

