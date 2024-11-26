package com.tutorlink.student_domain.auth.controller;

import com.tutorlink.student_domain.auth.service.RegistrationService;
import com.tutorlink.student_domain.auth.model.dto.request.RegisterUserReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/registration")
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<Void> registerNewUser(@Validated @RequestBody RegisterUserReq req) {
        registrationService.registerNewUser(req);
        return ResponseEntity.ok().build();
    }
}
