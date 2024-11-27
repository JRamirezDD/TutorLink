package com.tutorlink.tutor_domain.auth.controller;

import com.tutorlink.tutor_domain.auth.model.dto.request.TutorCredentialsReq;
import com.tutorlink.tutor_domain.auth.service.TutorAuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/tutor/auth")
@RequiredArgsConstructor
public class TutorAuthorizationController {

    private final TutorAuthorizationService tutorAuthorizationService;

    @PostMapping("/authorize")
    public ResponseEntity<Void> authorize(@RequestBody TutorCredentialsReq req, HttpServletResponse response) {
        tutorAuthorizationService.createSession(req, response);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/validate")
    public ResponseEntity<Void> validateToken(@RequestHeader("X-Session-Token") String token) {
        tutorAuthorizationService.verifyToken(token);
        return ResponseEntity.ok().build();
    }
}

