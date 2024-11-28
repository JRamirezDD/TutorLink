package com.tutorlink.matchmaking_domain.studentdomainmanager.controller;



import com.tutorlink.matchmaking_domain.studentdomainmanager.controller.APIs.API_StudentProfileRetrieval;
import com.tutorlink.matchmaking_domain.studentdomainmanager.model.dto.StudentProfileResp;
import com.tutorlink.matchmaking_domain.studentdomainmanager.service.StudentProfileRetrievalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentProfileRetrievalController implements API_StudentProfileRetrieval {

    private final StudentProfileRetrievalService studentProfileRetrievalService;

    public ResponseEntity<StudentProfileResp> getStudentProfile(@PathVariable Long studentId) {
        StudentProfileResp profile = studentProfileRetrievalService.getStudentProfile(studentId);
        return ResponseEntity.ok(profile);
    }
}

