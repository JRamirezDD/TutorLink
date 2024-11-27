package com.tutorlink.tutor_domain.auth.controller;

import com.tutorlink.tutor_domain.auth.model.dto.request.TutorRegistrationReq;
import com.tutorlink.tutor_domain.auth.service.TutorRegistrationService;
import com.tutorlink.tutor_domain.auth.model.dto.response.TutorRegistrationResp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutor")
@RequiredArgsConstructor
public class TutorRegistrationController {

    private final TutorRegistrationService tutorRegistrationService;


    @PostMapping("/register")
    public ResponseEntity<TutorRegistrationResp> register(@RequestBody TutorRegistrationReq req) {
        TutorRegistrationResp registrationResponse = tutorRegistrationService.registerNewTutor(req);
        return ResponseEntity.ok(registrationResponse);
    }
}

