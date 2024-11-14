package com.tutorlink.student_domain.functional.model.dto.response;

public record CourseDetailResp(
        Long courseId,
        String courseName,
        String tutorName,
        Long tutorId,
        Double hourlyRate,
        String description
) {
    // Static factory method to create a mock CourseDetailResp object
    public static CourseDetailResp mock() {
        return new CourseDetailResp(
                101L, // mock courseId
                "Mock Course Name", // mock courseName
                "Mock Tutor Name", // mock tutorName
                202L, // mock tutorId
                50.0, // mock hourlyRate
                "This is a mock course description." // mock description
        );
    }
}
