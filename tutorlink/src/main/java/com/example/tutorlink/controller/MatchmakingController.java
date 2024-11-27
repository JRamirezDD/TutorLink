package com.example.tutorlink.controller;

import com.example.tutorlink.model.dto.request.Matchmaking.MatchRequestReq;
import com.example.tutorlink.model.dto.request.Matchmaking.ValidateAuthReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Matchmaking Controller", description = "Student-tutor matchmaking endpoints")
@RestController
@RequestMapping("/matchmaking")
public class MatchmakingController {

    @Operation(description = "Send match request", summary = "Send matchmaking request")
    @PostMapping(
            value = "/request",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> sendMatchRequest(@RequestBody MatchRequestReq req) {
        return ResponseEntity.ok("Match request sent");
    }

    @Operation(description = "Validate student authentication", summary = "Validate student authentication")
    @PostMapping("/validate-student-authentication")
    public ResponseEntity<?> validateStudentAuthentication(@RequestBody ValidateAuthReq req) {
        return ResponseEntity.ok("Student authentication validated");
    }

    @Operation(description = "Validate tutor authentication", summary = "Validate tutor authentication")
    @PostMapping("/validate-tutor-authentication")
    public ResponseEntity<?> validateTutorAuthentication(@RequestBody ValidateAuthReq req) {
        return ResponseEntity.ok("Tutor authentication validated");
    }
}

