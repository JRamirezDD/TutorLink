package com.tutorlink.tutor_domain.functional.studentViewer.controller;


import com.tutorlink.tutor_domain.functional.studentViewer.model.dto.resp.StudentProfileResp;
import com.tutorlink.tutor_domain.functional.studentViewer.service.StudentViewerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students/view")
@RequiredArgsConstructor
public class StudentViewerController {

    private final StudentViewerService studentViewerService;

    //get specific student profile by ID
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentProfileResp> getStudentProfile(@PathVariable Long studentId) {
        StudentProfileResp profile = studentViewerService.getStudentProfile(studentId);
        return ResponseEntity.ok(profile);
    }

    //get all student profiles
    @GetMapping
    public ResponseEntity<List<StudentProfileResp>> getAllStudentProfiles() {
        List<StudentProfileResp> profiles = studentViewerService.getAllStudentProfiles();
        return ResponseEntity.ok(profiles);
    }
}

