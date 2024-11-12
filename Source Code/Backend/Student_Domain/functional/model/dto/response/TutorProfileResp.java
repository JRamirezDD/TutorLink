package com.tutorlink.student_domain.functional.model.dto.response;

public record TutorProfileResp(
        Long tutorId,
        String name,
        String expertise,
        Double rating,
        Double hourlyRate
) {}

