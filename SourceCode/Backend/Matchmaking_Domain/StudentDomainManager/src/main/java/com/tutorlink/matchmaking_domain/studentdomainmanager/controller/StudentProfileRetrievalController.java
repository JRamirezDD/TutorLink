package com.tutorlink.matchmaking_domain.studentdomainmanager.controller;



import com.tutorlink.matchmaking_domain.studentdomainmanager.model.dto.StudentProfileResp;
import com.tutorlink.matchmaking_domain.studentdomainmanager.service.StudentProfileRetrievalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentProfileRetrievalController {

    private final StudentProfileRetrievalService studentProfileRetrievalService;

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentProfileResp> getStudentProfile(@PathVariable Long studentId) {
        StudentProfileResp profile = studentProfileRetrievalService.getStudentProfile(studentId);
        return ResponseEntity.ok(profile);
    }
}

