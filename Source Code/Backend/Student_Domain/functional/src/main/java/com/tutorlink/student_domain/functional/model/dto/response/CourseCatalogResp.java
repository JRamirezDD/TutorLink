package com.tutorlink.student_domain.functional.model.dto.response;

public record CourseCatalogResp(
        Long courseId,
        String courseName,
        String tutorName,
        Long tutorId,
        Double hourlyRate,
        String location,
        String subject,
        String description
) {
    // Static factory method to create a mock CourseCatalogResp object
    public static CourseCatalogResp mock() {
        return new CourseCatalogResp(
                101L, // mock courseId
                "Mock Course Name", // mock courseName
                "Mock Tutor Name", // mock tutorName
                202L, // mock tutorId
                50.0, // mock hourlyRate
                "Mock location", // mock location
                "Mock subject", // mock subject
                "Mock description" // mock description
        );
    }
}
