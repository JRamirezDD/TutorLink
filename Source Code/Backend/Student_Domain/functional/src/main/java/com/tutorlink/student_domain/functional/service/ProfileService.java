package com.tutorlink.student_domain.functional.service;


import com.tutorlink.student_domain.functional.model.dto.request.UpdateProfileReq;
import com.tutorlink.student_domain.functional.model.dto.response.StudentProfileResp;
import com.tutorlink.student_domain.functional.model.dto.response.SubscriptionStatusResp;
import com.tutorlink.student_domain.functional.model.entity.StudentProfile;
import com.tutorlink.student_domain.functional.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    @Transactional(readOnly = true)
    public StudentProfileResp getStudentProfile(Long studentId) {
        StudentProfile profile = profileRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        return new StudentProfileResp(
                profile.getId(),
                profile.getUsername(),
                profile.getEmail(),
                profile.getJoinedDate()
        );
    }


    @Transactional
    public StudentProfileResp updateProfile(Long studentId, UpdateProfileReq req) {
        StudentProfile profile = profileRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        profile.setUsername(req.username());
        profile.setEmail(req.email());
        profileRepository.save(profile);

        return new StudentProfileResp(
                profile.getId(),
                profile.getUsername(),
                profile.getEmail(),
                profile.getJoinedDate()
        );
    }


    @Transactional(readOnly = true)
    public SubscriptionStatusResp getSubscriptionStatus(Long studentId) {
        StudentProfile profile = profileRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        return new SubscriptionStatusResp(
                profile.getSubscriptionPlan(),
                profile.getSubscriptionExpiryDate()
        );
    }
}



