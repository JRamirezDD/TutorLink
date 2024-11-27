package com.example.tutorlink.controller;


import com.example.tutorlink.model.dto.request.tutor.UpdateTutorProfileReq;
import com.example.tutorlink.model.dto.request.tutor.TutorSubjectsReq;
import com.example.tutorlink.model.dto.response.tutor.TutorProfileResp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Tutor Controller", description = "Tutor profile management endpoints")
@RestController
@RequestMapping("/tutors")
public class TutorController {

    @Operation(description = "Get tutor profile", summary = "Retrieve tutor profile")
    @GetMapping(value = "/{tutorId}/profile", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TutorProfileResp> getTutorProfile(@PathVariable Long tutorId) {
        return ResponseEntity.ok(TutorProfileResp.builder()
                .id(tutorId)
                .fullName("Marcos Gonzalez")
                .build());
    }

    @Operation(description = "Update tutor profile", summary = "Modify tutor profile")
    @PutMapping(
            value = "/{tutorId}/profile",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TutorProfileResp> updateTutorProfile(@PathVariable Long tutorId, @RequestBody UpdateTutorProfileReq req) {
        return ResponseEntity.ok(TutorProfileResp.builder()
                .id(tutorId)
                .fullName(req.getFullName())
                .build());
    }

    @Operation(description = "Manage tutor subjects", summary = "Select or modify tutor subjects")
    @PutMapping(value = "/{tutorId}/subjects", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> manageSubjects(@PathVariable Long tutorId, @RequestBody TutorSubjectsReq req) {
        return ResponseEntity.ok("Subjects updated");
    }

    @Operation(description = "Delete tutor profile", summary = "Delete tutor account")
    @DeleteMapping("/{tutorId}/delete")
    public ResponseEntity<?> deleteTutor(@PathVariable Long tutorId) {
        return ResponseEntity.ok("Tutor profile deleted");
    }
}

