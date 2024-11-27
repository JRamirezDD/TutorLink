package com.example.tutorlink.controller;

import com.example.tutorlink.model.dto.request.auth.UserCredentialsReq;
import com.example.tutorlink.model.dto.request.auth.UserRegistrationReq;
import com.example.tutorlink.model.dto.response.auth.UserInfoResp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Tutor Auth Controller", description = "Tutor Authentication and Authorization Endpoints")
@RestController
@RequestMapping("/tutor/auth")
public class TutorAuthController {

    @Operation(description = "Login tutor", summary = "Tutor login")
    @PostMapping(
            value = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserInfoResp> login(@RequestBody UserCredentialsReq req) {
        return ResponseEntity.ok(UserInfoResp.builder()
                .id(15L)
                .username(req.getUsername())
                .type("Tutor")
                .build());
    }

    @Operation(description = "Register tutor", summary = "Tutor registration")
    @PostMapping(
            value = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserInfoResp> register(@RequestBody UserRegistrationReq req) {
        return ResponseEntity.ok(UserInfoResp.builder()
                .id(20L)
                .username(req.getUsername())
                .type("Tutor")
                .build());
    }
}

