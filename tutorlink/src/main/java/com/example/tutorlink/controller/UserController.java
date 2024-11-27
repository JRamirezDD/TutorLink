package com.example.tutorlink.controller;

import com.example.tutorlink.model.dto.request.user.UpdateUserProfileReq;
import com.example.tutorlink.model.dto.response.user.UserProfileResp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name = "User Controller", description = "User profile management endpoints")
@RestController
@RequestMapping("/users")
public class UserController {

    @Operation(description = "Get user profile", summary = "Retrieve user profile details")
    @GetMapping(value = "/{userId}/profile", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserProfileResp> getUserProfile(@PathVariable Long userId) {
        return ResponseEntity.ok(UserProfileResp.builder()
                .id(userId)
                .fullName("Gio Kandelaki")
                .email("gkandelaki@gmail.com")
                .build());
    }

    @Operation(description = "Update user profile", summary = "Modify user profile")
    @PutMapping(
            value = "/{userId}/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserProfileResp> updateUserProfile(@PathVariable Long userId, @RequestBody UpdateUserProfileReq req) {
        return ResponseEntity.ok(UserProfileResp.builder()
                .id(userId)
                .fullName(req.getFullName())
                .email(req.getEmail())
                .build());
    }

    @Operation(description = "Delete user account", summary = "Delete user profile")
    @DeleteMapping("/{userId}/delete")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        return ResponseEntity.ok("profile deleted");
    }

    @Operation(description = "Upgrade to gold user", summary = "Upgrade user to gold")
    @PostMapping("/{userId}/upgrade")
    public ResponseEntity<?> upgradeToGold(@PathVariable Long userId) {
        return ResponseEntity.ok("user upgraded to gold");
    }
}

