package com.tutorlink.student_domain.functional.model.dto.response;

public record CourseDetailResp(
        Long courseId,
        String courseName,
        String tutorName,
        Long tutorId,
        Double hourlyRate,
        String description
) {}

