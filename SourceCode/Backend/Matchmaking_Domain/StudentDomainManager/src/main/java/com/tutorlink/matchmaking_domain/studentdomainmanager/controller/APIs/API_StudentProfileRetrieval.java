package com.tutorlink.matchmaking_domain.studentdomainmanager.controller.APIs;

import com.tutorlink.matchmaking_domain.studentdomainmanager.model.dto.StudentProfileResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface API_StudentProfileRetrieval {

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentProfileResp> getStudentProfile(@PathVariable Long studentId);
}
