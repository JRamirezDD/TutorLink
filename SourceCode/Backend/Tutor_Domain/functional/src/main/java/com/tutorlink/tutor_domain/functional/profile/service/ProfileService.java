package com.tutorlink.tutor_domain.functional.profile.service;

import com.tutorlink.tutor_domain.functional.profile.model.dto.req.CreateTutorProfileReq;
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
        profile.setDescription(updateRequest.description());
        profile.setLocation(updateRequest.location());

        TutorProfile updatedProfile = profileRepository.save(profile);
        return mapToTutorProfileResp(updatedProfile);
    }

    public TutorProfileResp createTutorProfile(CreateTutorProfileReq createRequest) {
        TutorProfile profile = TutorProfile.builder()
                .name(createRequest.name())
                .email(createRequest.email())
                .specialization(createRequest.specialization())
                .hourlyRate(createRequest.hourlyRate()) // Use input value
                .description("") // Set to empty or use a description field in the request
                .location("") // Same as description
                .build();
  
        TutorProfile savedProfile = profileRepository.save(profile);
  
        return mapToTutorProfileResp(savedProfile);
    }
    

    private TutorProfileResp mapToTutorProfileResp(TutorProfile profile) {
        return TutorProfileResp.builder()
                .tutorId(profile.getId())
                .name(profile.getName())
                .email(profile.getEmail())
                .specialization(profile.getSpecialization())
                .hourlyRate(profile.getHourlyRate().orElse(null))
                .description(profile.getDescription().orElse(null))
                .location(profile.getLocation().orElse(null))
                .build();
    }
}
