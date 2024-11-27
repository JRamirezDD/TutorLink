package com.tutorlink.student_domain.functional.model.dto.request;

import jakarta.validation.constraints.NotNull;

public record EnrollmentReq(
        @NotNull Long studentId
) {
    // Static factory method to create a mock EnrollmentReq object
    public static EnrollmentReq mock() {
        return new EnrollmentReq(
                12345L // mock studentId
        );
    }
}