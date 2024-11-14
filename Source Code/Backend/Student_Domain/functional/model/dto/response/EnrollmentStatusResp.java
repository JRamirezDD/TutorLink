package com.tutorlink.student_domain.functional.model.dto.response;

public record EnrollmentStatusResp(
        Long courseId,
        Long studentId,
        String status
) {
    // Static factory method to create a mock EnrollmentStatusResp object
    public static EnrollmentStatusResp mock() {
        return new EnrollmentStatusResp(
                101L, // mock courseId
                12345L, // mock studentId
                "Enrolled" // mock status
        );
    }
}
