package com.tutorlink.student_domain.functional.model.dto.response;

public record CourseCatalogResp(
        Long courseId,
        String courseName,
        String tutorName,
        Long tutorId,
        Double hourlyRate
) {}


