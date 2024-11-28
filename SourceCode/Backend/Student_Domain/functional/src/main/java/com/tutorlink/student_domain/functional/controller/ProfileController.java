package com.tutorlink.student_domain.functional.controller;


import com.tutorlink.student_domain.functional.controller.APIs.API_Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorlink.student_domain.functional.model.dto.request.UpdateProfileReq;
import com.tutorlink.student_domain.functional.model.dto.response.StudentProfileResp;
import com.tutorlink.student_domain.functional.model.dto.response.SubscriptionStatusResp;
import com.tutorlink.student_domain.functional.service.ProfileService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController implements API_Profile {

    private final ProfileService profileService;

    //view a student profile by ID
    public ResponseEntity<StudentProfileResp> getStudentProfile(@PathVariable Long id) {
        // StudentProfileResp profile = profileService.getStudentProfile(id);
        StudentProfileResp profile = StudentProfileResp.mock();
        return ResponseEntity.ok(profile);
    }

    //view the student’s own profile
    public ResponseEntity<StudentProfileResp> getOwnProfile() {
        Long currentStudentId = getCurrentStudentId();
        // StudentProfileResp profile = profileService.getStudentProfile(currentStudentId);
        StudentProfileResp profile = StudentProfileResp.mock();
        return ResponseEntity.ok(profile);
    }

    //update the student’s own profile
    public ResponseEntity<StudentProfileResp> updateOwnProfile(@RequestBody UpdateProfileReq req) {
        Long currentStudentId = getCurrentStudentId();
        // StudentProfileResp updatedProfile = profileService.updateProfile(currentStudentId, req);
        StudentProfileResp updatedProfile = StudentProfileResp.mock();
        return ResponseEntity.ok(updatedProfile);
    }

    //view the student's subscription status (only accessible by the student)
    public ResponseEntity<SubscriptionStatusResp> getSubscriptionStatus() {
        Long currentStudentId = getCurrentStudentId();
        // SubscriptionStatusResp subscriptionStatus = profileService.getSubscriptionStatus(currentStudentId);
        SubscriptionStatusResp subscriptionStatus = SubscriptionStatusResp.mock();
        return ResponseEntity.ok(subscriptionStatus);
    }

    public Long getCurrentStudentId() {
        //TODO: retrieve the current user's ID
        return 1L;
    }
}


