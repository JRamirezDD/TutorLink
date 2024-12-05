package com.tutorlink.student_domain.auth.controller;

import com.tutorlink.student_domain.auth.model.dto.request.RegisterUserReq;
import com.tutorlink.student_domain.auth.model.dto.request.UserLoginReq;
import com.tutorlink.student_domain.auth.model.entity.UserEntity;
import com.tutorlink.student_domain.auth.service.AuthenticationService;
import com.tutorlink.student_domain.auth.service.GoogleOAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final GoogleOAuthService googleOAuthService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginReq loginRequest) {
        try {
            String sessionToken = authenticationService.login(loginRequest);
            ResponseCookie cookie = ResponseCookie.from("SESSIONTOKEN", sessionToken)
                    .path("/")
                    .maxAge(900)
                    .build();
            return ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, cookie.toString())
                    .build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/user")
    public ResponseEntity<UserEntity> getUserFromSessionToken(@CookieValue("SESSIONTOKEN") String token) {
        try {
            UserEntity user = authenticationService.getUserFromSessionToken(token);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping("/google-login")
    public ResponseEntity<String> googleLogin(@RequestParam("access_token") String accessToken) {
        try {
            String sessionToken = googleOAuthService.login(accessToken);
            ResponseCookie cookie = ResponseCookie.from("SESSIONTOKEN", sessionToken)
                    .path("/")
                    .maxAge(900)
                    .build();
            return ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, cookie.toString())
                    .build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerNewUser(@RequestBody RegisterUserReq req) {
        try {
            authenticationService.register(req);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@CookieValue("SESSIONTOKEN") String token) {
        try {
            authenticationService.invalidateSessionToken(token);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/validate-session")
    public boolean validateSession(@RequestHeader("SESSIONTOKEN") String sessionToken) {
        return authenticationService.isSessionTokenValid(sessionToken);
    }
}
