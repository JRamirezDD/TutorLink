// package com.tutorlink.student_domain.functional;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.when;

// import com.tutorlink.student_domain.functional.model.dto.request.CreateStudentProfileReq;
// import com.tutorlink.student_domain.functional.model.dto.response.StudentProfileResp;
// import com.tutorlink.student_domain.functional.model.entity.StudentProfile;
// import com.tutorlink.student_domain.functional.repository.StudentProfileRepository;
// import com.tutorlink.student_domain.functional.service.StudentProfileService;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest
// class FunctionalStudentApplicationTests {

//     @Mock
//     private StudentProfileRepository profileRepository;

//     @InjectMocks
//     private StudentProfileService profileService;

//     @BeforeEach
//     void setUp() {
//         MockitoAnnotations.openMocks(this); // Initialize mocks
//     }

//     @Test
//     void testCreateStudentProfile_Success() {
//         // Arrange
//         CreateStudentProfileReq mockRequest = new CreateStudentProfileReq("John Doe", "john.doe@example.com");

//         // Mock entity to simulate repository behavior
//         StudentProfile mockEntity = StudentProfile.builder()
//                 .id(1L)
//                 .name(mockRequest.name())
//                 .email(mockRequest.email())
//                 .subscriptionLevel("Silver") // Default subscription level
//                 .build();

//         // Mock the save method of the repository
//         when(profileRepository.save(any(StudentProfile.class))).thenReturn(mockEntity);

//         // Act
//         StudentProfileResp response = profileService.createStudentProfile(mockRequest);

//         // Assert
//         assertEquals(mockEntity.getId(), response.id(), "The ID should match");
//         assertEquals(mockEntity.getName(), response.username(), "The username should match");
//         assertEquals(mockEntity.getEmail(), response.email(), "The email should match");
//         assertEquals(mockEntity.getSubscriptionLevel(), response.subscriptionLevel(), "The subscription level should match");
//     }
// }
