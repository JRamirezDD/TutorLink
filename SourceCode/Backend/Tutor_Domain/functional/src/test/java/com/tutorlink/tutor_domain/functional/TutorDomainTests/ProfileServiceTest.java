package com.tutorlink.tutor_domain.functional.TutorDomainTests;

import com.tutorlink.tutor_domain.functional.profile.model.dto.req.CreateTutorProfileReq;
import com.tutorlink.tutor_domain.functional.profile.model.dto.resp.TutorProfileResp;
import com.tutorlink.tutor_domain.functional.profile.model.entity.TutorProfile;
import com.tutorlink.tutor_domain.functional.profile.repository.ProfileRepository;
import com.tutorlink.tutor_domain.functional.profile.service.ProfileService;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProfileServiceTest {

    @Mock
    private ProfileRepository profileRepository;

    @InjectMocks
    private ProfileService profileService;

    public ProfileServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTutorProfile_Success() {
        // Arrange
        CreateTutorProfileReq request = new CreateTutorProfileReq("MockName", "Mock@email.com", "Mathematics", 40.0);

        TutorProfile mockEntity = TutorProfile.builder()
                .id(1L)
                .name(request.name())
                .email(request.email())
                .specialization(request.specialization())
                .build();

        when(profileRepository.save(any(TutorProfile.class))).thenReturn(mockEntity);

        // Act
        TutorProfileResp response = profileService.createTutorProfile(request);

        // Assert
        assertEquals(mockEntity.getId(), response.tutorId());
        assertEquals(mockEntity.getName(), response.name());
        assertEquals(mockEntity.getEmail(), response.email());
        assertEquals(mockEntity.getSpecialization(), response.specialization());

        // Verify
        verify(profileRepository, times(1)).save(any(TutorProfile.class));
    }

    @Test
    void testGetTutorProfile_Success() {
        // Arrange
        Long tutorId = 1L;
        TutorProfile mockEntity = TutorProfile.builder()
                .id(tutorId)
                .name("Jane Doe")
                .email("jane.doe@example.com")
                .specialization("Physics")
                .build();

        when(profileRepository.findById(tutorId)).thenReturn(Optional.of(mockEntity));

        // Act
        TutorProfileResp response = profileService.getTutorProfile(tutorId);

        // Assert
        assertEquals(mockEntity.getId(), response.tutorId());
        assertEquals(mockEntity.getName(), response.name());
        assertEquals(mockEntity.getEmail(), response.email());
        assertEquals(mockEntity.getSpecialization(), response.specialization());

        // Verify
        verify(profileRepository, times(1)).findById(tutorId);
    }
}
