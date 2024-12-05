package com.tutorlink.student_domain.functional;

import com.tutorlink.student_domain.functional.controller.StudentProfileController;
import com.tutorlink.student_domain.functional.model.dto.request.UpdateStudentProfileReq;
import com.tutorlink.student_domain.functional.model.dto.response.StudentProfileResp;
import com.tutorlink.student_domain.functional.service.StudentProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class StudentProfileControllerTest {

    @Mock
    private StudentProfileService studentProfileService;

    @InjectMocks
    private StudentProfileController studentProfileController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateStudentProfile() {
        UpdateStudentProfileReq request = new UpdateStudentProfileReq("TestName", "test@example.com", "Gold");
        StudentProfileResp mockResponse = StudentProfileResp.mock();

        when(studentProfileService.createStudentProfile(any(UpdateStudentProfileReq.class)))
                .thenReturn(mockResponse);

        ResponseEntity<StudentProfileResp> response = studentProfileController.createStudentProfile(request);

        assertNotNull(response.getBody());
    }
}