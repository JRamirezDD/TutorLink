package com.tutorlink.tutor_domain.functional.profile.service;


import com.tutorlink.tutor_domain.functional.profile.model.dto.req.UpdateTutorProfileReq;
import com.tutorlink.tutor_domain.functional.profile.model.dto.resp.TutorProfileResp;
import com.tutorlink.tutor_domain.functional.profile.model.entity.TutorProfile;
import com.tutorlink.tutor_domain.functional.profile.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public TutorProfileResp getTutorProfile(Long tutorId) {
        TutorProfile profile = profileRepository.findById(tutorId)
                .orElseThrow(() -> new RuntimeException("Tutor profile not found"));
        return mapToTutorProfileResp(profile);
    }

    public List<TutorProfileResp> getAllTutorProfiles() {
        return profileRepository.findAll().stream()
                .map(this::mapToTutorProfileResp)
                .collect(Collectors.toList());
    }

    public TutorProfileResp updateTutorProfile(Long tutorId, UpdateTutorProfileReq updateRequest) {
        TutorProfile profile = profileRepository.findById(tutorId)
                .orElseThrow(() -> new RuntimeException("Tutor profile not found"));

        profile.setName(updateRequest.name());
        profile.setEmail(updateRequest.email());
        profile.setSpecialization(updateRequest.specialization());
        profile.setHourlyRate(updateRequest.hourlyRate());

        TutorProfile updatedProfile = profileRepository.save(profile);
        return mapToTutorProfileResp(updatedProfile);
    }

    private TutorProfileResp mapToTutorProfileResp(TutorProfile profile) {
        return TutorProfileResp.builder()
                .tutorId(profile.getId())
                .name(profile.getName())
                .email(profile.getEmail())
                .specialization(profile.getSpecialization())
                .hourlyRate(profile.getHourlyRate())
                .build();
    }
}

