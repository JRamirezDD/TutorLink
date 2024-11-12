package com.tutorlink.student_domain.functional.controller;


import com.tutorlink.student_domain.functional.model.dto.request.UpdateProfileReq;
import com.tutorlink.student_domain.functional.model.dto.response.StudentProfileResp;
import com.tutorlink.student_domain.functional.model.dto.response.SubscriptionStatusResp;
import com.tutorlink.student_domain.functional.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    //view a student profile by ID
    @Operation(summary = "View a student profile by ID", description = "Allows viewing a specific student's profile by their ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student profile retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudentProfileResp.class),
                            examples = @ExampleObject(value = "{\"id\": 1, \"name\": \"Gio Kandelaki\", \"email\": \"giokandelaki@something.com\", \"subscriptionLevel\": \"Gold\"}")
                    )),
            @ApiResponse(responseCode = "404", description = "Student profile not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<StudentProfileResp> getStudentProfile(@PathVariable Long id) {
        StudentProfileResp profile = profileService.getStudentProfile(id);
        return ResponseEntity.ok(profile);
    }

    //view the student’s own profile
    @Operation(summary = "View the student’s own profile", description = "Retrieves the profile of the currently authenticated student.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Own profile retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudentProfileResp.class),
                            examples = @ExampleObject(value = "{\"id\": 1, \"name\": \"Gio Kandelaki\", \"email\": \"giokandelaki@something.com\", \"subscriptionLevel\": \"Gold\"}")
                    )),
            @ApiResponse(responseCode = "401", description = "Unauthorized access")
    })
    @GetMapping
    public ResponseEntity<StudentProfileResp> getOwnProfile() {
        Long currentStudentId = getCurrentStudentId();
        StudentProfileResp profile = profileService.getStudentProfile(currentStudentId);
        return ResponseEntity.ok(profile);
    }

    //update the student’s own profile
    @Operation(summary = "Update the student’s own profile", description = "Allows the student to update their profile details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profile updated successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudentProfileResp.class),
                            examples = @ExampleObject(value = "{\"id\": 1, \"name\": \"Gio Kandelaki\", \"email\": \"v\", \"subscriptionLevel\": \"Gold\"}")
                    )),
            @ApiResponse(responseCode = "400", description = "Invalid update request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access")
    })
    @PutMapping
    public ResponseEntity<StudentProfileResp> updateOwnProfile(@RequestBody UpdateProfileReq req) {
        Long currentStudentId = getCurrentStudentId();
        StudentProfileResp updatedProfile = profileService.updateProfile(currentStudentId, req);
        return ResponseEntity.ok(updatedProfile);
    }

    //view the student's subscription status (only accessible by the student)
    @Operation(summary = "View the student's subscription status", description = "Retrieves the subscription status of the currently authenticated student.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Subscription status retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SubscriptionStatusResp.class),
                            examples = @ExampleObject(value = "{\"studentId\": 1, \"subscriptionLevel\": \"Gold\", \"expiryDate\": \"2024-12-31T00:00:00\"}")
                    )),
            @ApiResponse(responseCode = "401", description = "Unauthorized access")
    })
    @GetMapping("/subscription")
    public ResponseEntity<SubscriptionStatusResp> getSubscriptionStatus() {
        Long currentStudentId = getCurrentStudentId();
        SubscriptionStatusResp subscriptionStatus = profileService.getSubscriptionStatus(currentStudentId);
        return ResponseEntity.ok(subscriptionStatus);
    }

    private Long getCurrentStudentId() {
        //TODO: retrieve the current user's ID
        return 1L;
    }
}


