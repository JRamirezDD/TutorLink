package com.example.tutorlink.controller;

import com.example.tutorlink.model.dto.request.auth.UserCredentialsReq;
import com.example.tutorlink.model.dto.request.auth.UserRegistrationReq;
import com.example.tutorlink.model.dto.response.auth.UserInfoResp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User Auth Controller", description = "User Authentication and Authorization Endpoints")
@RestController
@RequestMapping("/user/auth")
public class StudentAuthController {

    @Operation(description = "Login user", summary = "User login")
    @PostMapping(
            value = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserInfoResp> login(@RequestBody UserCredentialsReq req) {
        return ResponseEntity.ok(UserInfoResp.builder()
                .id(5L)
                .username(req.getUsername())
                .type("Silver")
                .build());
    }

    @Operation(description = "Register user", summary = "User registration")
    @PostMapping(
            value = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserInfoResp> register(@RequestBody UserRegistrationReq req) {
        return ResponseEntity.ok(UserInfoResp.builder()
                .id(10L) // Example user ID
                .username(req.getUsername())
                .type("Silver")
                .build());
    }
}




