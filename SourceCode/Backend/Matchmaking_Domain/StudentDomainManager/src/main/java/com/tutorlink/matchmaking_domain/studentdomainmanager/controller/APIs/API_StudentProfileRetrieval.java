package com.tutorlink.matchmaking_domain.studentdomainmanager.controller.APIs;

import com.tutorlink.matchmaking_domain.studentdomainmanager.model.dto.req.UpdateStudentProfileReq;
import com.tutorlink.matchmaking_domain.studentdomainmanager.model.dto.resp.StudentProfileResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface API_StudentProfileRetrieval {

    @GetMapping("/{studentId}")
    ResponseEntity<StudentProfileResp> getStudentProfile(@PathVariable Long studentId);

    @PutMapping("/{studentId}")
    ResponseEntity<StudentProfileResp> updateStudentProfile(
            @PathVariable Long studentId,
            @RequestBody UpdateStudentProfileReq request
    );
}
