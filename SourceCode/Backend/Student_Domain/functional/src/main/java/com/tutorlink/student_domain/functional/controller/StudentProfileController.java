package com.tutorlink.student_domain.functional.controller;

import com.tutorlink.student_domain.functional.model.dto.request.UpdateStudentProfileReq;
import com.tutorlink.student_domain.functional.model.dto.response.StudentProfileResp;
import com.tutorlink.student_domain.functional.service.StudentProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentProfileResp> getProfile(@PathVariable Long studentId) {
        StudentProfileResp profile = studentProfileService.getStudentProfile(studentId);
        return ResponseEntity.ok(profile);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentProfileResp> updateProfile(
            @PathVariable Long studentId,
            @RequestBody UpdateStudentProfileReq request) {
        StudentProfileResp profile = studentProfileService.updateStudentProfile(studentId, request);
        return ResponseEntity.ok(profile);
    }
}
