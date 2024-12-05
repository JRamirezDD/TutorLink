package functional.StudentDomainTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tutorlink.student_domain.functional.model.dto.response.StudentProfileResp;
import com.tutorlink.student_domain.functional.model.entity.StudentProfile;
import com.tutorlink.student_domain.functional.repository.StudentProfileRepository;
import com.tutorlink.student_domain.functional.service.StudentProfileService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class StudentProfileServiceTest {

    @Mock
    private StudentProfileRepository studentProfileRepository;

    @InjectMocks
    private StudentProfileService studentProfileService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetStudentProfile_Success() {
        // Mock data
        Long studentId = 1L;
        StudentProfile mockProfile = StudentProfile.builder()
                .id(studentId)
                .name("John Doe")
                .email("johndoe@example.com")
                .build();

        // Mock repository behavior
        when(studentProfileRepository.findById(studentId)).thenReturn(Optional.of(mockProfile));

        // Call service method
        StudentProfileResp response = studentProfileService.getStudentProfile(studentId);

        // Assertions
        assertEquals(studentId, response.id());
        assertEquals("John Doe", response.username());
        assertEquals("johndoe@example.com", response.email());

        // Verify repository call
        verify(studentProfileRepository, times(1)).findById(studentId);
    }

    @Test
    void testGetStudentProfile_NotFound() {
        // Mock data
        Long studentId = 1L;

        // Mock repository behavior
        when(studentProfileRepository.findById(studentId)).thenReturn(Optional.empty());

        // Call service method and assert exception
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            studentProfileService.getStudentProfile(studentId);
        });

        assertEquals("Student profile not found", exception.getMessage());

        // Verify repository call
        verify(studentProfileRepository, times(1)).findById(studentId);
    }
}
