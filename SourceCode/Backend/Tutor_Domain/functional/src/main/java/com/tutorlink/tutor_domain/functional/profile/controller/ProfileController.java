package com.tutorlink.tutor_domain.functional.profile.controller;


import com.tutorlink.tutor_domain.functional.profile.model.dto.req.UpdateTutorProfileReq;
import com.tutorlink.tutor_domain.functional.profile.model.dto.resp.TutorProfileResp;
import com.tutorlink.tutor_domain.functional.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutors/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    //get tutor profile by ID
    @GetMapping("/{tutorId}")
    public ResponseEntity<TutorProfileResp> getTutorProfile(@PathVariable Long tutorId) {
        TutorProfileResp profile = profileService.getTutorProfile(tutorId);
        return ResponseEntity.ok(profile);
    }

    //get all tutor profiles
    @GetMapping
    public ResponseEntity<List<TutorProfileResp>> getAllTutorProfiles() {
        List<TutorProfileResp> profiles = profileService.getAllTutorProfiles();
        return ResponseEntity.ok(profiles);
    }

    //get tutor’s own profile
    @GetMapping("/me")
    public ResponseEntity<TutorProfileResp> getOwnProfile() {
        Long currentTutorId = getCurrentTutorId();
        TutorProfileResp profile = profileService.getTutorProfile(currentTutorId);
        return ResponseEntity.ok(profile);
    }

    //update tutor profile
    @PutMapping("/{tutorId}")
    public ResponseEntity<TutorProfileResp> updateTutorProfile(
            @PathVariable Long tutorId,
            @RequestBody UpdateTutorProfileReq updateRequest) {
        TutorProfileResp updatedProfile = profileService.updateTutorProfile(tutorId, updateRequest);
        return ResponseEntity.ok(updatedProfile);
    }

    //mock method rn
    private Long getCurrentTutorId() {
        // TODO: make logic for getting tutor ID
        return 1L;
    }
}


