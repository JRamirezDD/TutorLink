package com.tutorlink.student_domain.functional.controller.APIs;

import com.tutorlink.matchmaking_domain.studentdomainmanager.controller.APIs.API_StudentProfileRetrieval;
import com.tutorlink.student_domain.functional.model.dto.request.UpdateProfileReq;
import com.tutorlink.student_domain.functional.model.dto.response.StudentProfileResp;
import com.tutorlink.student_domain.functional.model.dto.response.SubscriptionStatusResp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface API_Profile extends API_StudentProfileRetrieval {

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
    public ResponseEntity<StudentProfileResp> getOwnProfile();

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
    public ResponseEntity<StudentProfileResp> updateOwnProfile(@RequestBody UpdateProfileReq req);

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
    public ResponseEntity<SubscriptionStatusResp> getSubscriptionStatus();

    public Long getCurrentStudentId();
}
