package com.example.tutorlink.controller;

import com.example.tutorlink.model.dto.request.auth.UserCredentialsReq;
import com.example.tutorlink.model.dto.request.auth.UserRegistrationReq;
import com.example.tutorlink.model.dto.response.auth.UserInfoResp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Auth Controller", description = "Authentication endpoints")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Operation(description = "Login User", summary = "User Login")
    @PostMapping(
            value = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserInfoResp> login(@RequestBody UserCredentialsReq req, @RequestParam String type) {
        return ResponseEntity.ok(UserInfoResp.builder()
                .id(5L)
                .username(req.getUsername())
                .type(type)
                .build());
    }

    @Operation(description = "Register User", summary = "User Registration")
    @PostMapping(
            value = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserInfoResp> register(@RequestBody UserRegistrationReq req) {
        return ResponseEntity.ok(UserInfoResp.builder()
                .id(10L)
                .username(req.getUsername())
                .build());
    }
}



