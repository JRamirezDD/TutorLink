package com.tutorlink.student_domain.functional.model.dto.response;

public record CourseCatalogResp(
        Long courseId,
        String courseName,
        String tutorName,
        Long tutorId,
        Double hourlyRate
) {
    // Static factory method to create a mock CourseCatalogResp object
    public static CourseCatalogResp mock() {
        return new CourseCatalogResp(
                101L, // mock courseId
                "Mock Course Name", // mock courseName
                "Mock Tutor Name", // mock tutorName
                202L, // mock tutorId
                50.0 // mock hourlyRate
        );
    }
}
