package com.tutorlink.matchmaking_domain.studentdomainmanager.controller;

import com.tutorlink.matchmaking_domain.studentdomainmanager.controller.APIs.API_StudentProfileRetrieval;
import com.tutorlink.matchmaking_domain.studentdomainmanager.model.dto.req.UpdateStudentProfileReq;
import com.tutorlink.matchmaking_domain.studentdomainmanager.model.dto.resp.StudentProfileResp;
import com.tutorlink.matchmaking_domain.studentdomainmanager.service.StudentProfileRetrievalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentProfileRetrievalController implements API_StudentProfileRetrieval {

    private final StudentProfileRetrievalService studentProfileRetrievalService;

    public ResponseEntity<StudentProfileResp> getStudentProfile(Long studentId) {
        StudentProfileResp profile = studentProfileRetrievalService.getStudentProfile(studentId);
        return ResponseEntity.ok(profile);
    }

    public ResponseEntity<StudentProfileResp> updateStudentProfile(
            Long studentId,
            UpdateStudentProfileReq request) {
        StudentProfileResp profile = studentProfileRetrievalService.updateStudentProfile(studentId, request);
        return ResponseEntity.ok(profile);
    }
}



