package com.tutorlink.student_domain.functional.model.dto.response;

public record TutorProfileResp(
        Long tutorId,
        String name,
        String expertise,
        Double rating,
        Double hourlyRate
) {
    // Static factory method to create a mock TutorProfileResp object
    public static TutorProfileResp mock() {
        return new TutorProfileResp(
                1L, // mock tutorId
                "Mock Tutor Name", // mock name
                "Mock Expertise", // mock expertise
                4.5, // mock rating
                50.0 // mock hourlyRate
        );
    }
}
