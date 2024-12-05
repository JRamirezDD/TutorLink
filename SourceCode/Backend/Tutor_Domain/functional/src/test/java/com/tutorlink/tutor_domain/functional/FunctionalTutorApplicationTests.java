package com.tutorlink.tutor_domain.functional;

import com.tutorlink.matchmaking_domain.studentdomainmanager.model.dto.resp.StudentProfileResp;
import com.tutorlink.tutor_domain.functional.studentViewer.controller.StudentViewerController;
import com.tutorlink.tutor_domain.functional.studentViewer.service.StudentViewerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class StudentViewerControllerTest {

    @Mock
    private StudentViewerService studentViewerService;

    @InjectMocks
    private StudentViewerController studentViewerController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetStudentProfile() {
        // Arrange
        Long studentId = 1L;
        StudentProfileResp mockProfile = StudentProfileResp.builder()
                .studentId(studentId)
                .name("bob")
                .email("bob@gmail.com")
                .subscriptionLevel("SILVER")
                .build();

        // Mocking service method
        when(studentViewerService.getStudentProfile(studentId)).thenReturn(mockProfile);

        // Act
        ResponseEntity<StudentProfileResp> responseEntity = studentViewerController.getStudentProfile(studentId);

        // Assert
        assertEquals(ResponseEntity.ok(mockProfile), responseEntity);
    }
}