package com.tutorlink.matchmaking_domain.studentdomainmanager.controller;

import com.tutorlink.matchmaking_domain.studentdomainmanager.model.dto.resp.StudentProfileResp;
import com.tutorlink.matchmaking_domain.studentdomainmanager.service.StudentProfileRetrievalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class StudentProfileRetrievalControllerTest {

    @Mock
    private StudentProfileRetrievalService studentProfileRetrievalService;

    @InjectMocks
    private StudentProfileRetrievalController studentProfileRetrievalController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetStudentProfile() {
        //Arrange
        Long studentId = 1L;
        StudentProfileResp mockResponse = StudentProfileResp.builder()
                .studentId(studentId)
                .name("Bob")
                .email("bob@gmail.com")
                .subscriptionLevel("SILVER")
                .build();

        when(studentProfileRetrievalService.getStudentProfile(anyLong())).thenReturn(mockResponse);

        //Act
        ResponseEntity<StudentProfileResp> responseEntity = studentProfileRetrievalController.getStudentProfile(studentId);

        //Assert
        assertEquals(ResponseEntity.ok(mockResponse), responseEntity);
    }
}