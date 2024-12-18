package com.tutorlink.student_domain.functional.controller;

import com.tutorlink.student_domain.functional.model.dto.response.TutorProfileResp;
import com.tutorlink.student_domain.functional.service.TutorViewerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutors")
@RequiredArgsConstructor
public class TutorViewerController {

    private final TutorViewerService tutorViewerService;

    @Operation(summary = "Get all tutors", description = "Returns a list of available tutors with basic profile information.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of tutors retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TutorProfileResp.class),
                            examples = @ExampleObject(value = "[{\"tutorId\": 1, \"name\": \"John Doe\", \"expertise\": \"Mathematics\", \"rating\": 4.5, \"hourlyRate\": 30.0}]")
                    ))
    })
    @GetMapping
    public ResponseEntity<List<com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.model.dto.resp.TutorProfileResp>> getAllTutors() {
        List<com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.model.dto.resp.TutorProfileResp> tutors = tutorViewerService.getAllTutors();
        return ResponseEntity.ok(tutors);
    }

    @Operation(summary = "Get a tutor profile by ID", description = "Retrieves detailed information of a specific tutor by their ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tutor profile retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TutorProfileResp.class),
                            examples = @ExampleObject(value = "{\"tutorId\": 1, \"name\": \"John Doe\", \"expertise\": \"Mathematics\", \"rating\": 4.5, \"hourlyRate\": 30.0}")
                    )),
            @ApiResponse(responseCode = "404", description = "Tutor not found"),
            @ApiResponse(responseCode = "400", description = "Invalid tutor ID")
    })
    @GetMapping("/{tutorId}")
    public ResponseEntity<com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.model.dto.resp.TutorProfileResp> getTutorProfile(@PathVariable Long tutorId) {
        com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.model.dto.resp.TutorProfileResp tutorProfile = tutorViewerService.getTutorProfileById(tutorId);
        return ResponseEntity.ok(tutorProfile);
    }
}

