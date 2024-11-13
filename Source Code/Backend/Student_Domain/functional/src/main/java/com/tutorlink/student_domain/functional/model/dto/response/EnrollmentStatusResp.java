package com.tutorlink.student_domain.functional.model.dto.response;


public record EnrollmentStatusResp(
        Long courseId,
        Long studentId,
        String status
) {}

