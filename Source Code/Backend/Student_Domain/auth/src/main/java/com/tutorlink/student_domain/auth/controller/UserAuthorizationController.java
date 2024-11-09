package com.tutorlink.student_domain.auth.controller;

import com.tutorlink.student_domain.auth.model.dto.request.UserCredentialsReq;
import com.tutorlink.student_domain.auth.service.UserAuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class
UserAuthorizationController {

    private final UserAuthorizationService authorizationService;

    @PostMapping("/authorize")
    public ResponseEntity<Void> authorize(@RequestBody UserCredentialsReq req, HttpServletResponse response) {
        authorizationService.createSession(req, response);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/validate")
    public ResponseEntity<Void> validateToken(@RequestHeader("X-Session-Token") String token) {
        authorizationService.verifyToken(token);
        return ResponseEntity.ok().build();
    }
}

