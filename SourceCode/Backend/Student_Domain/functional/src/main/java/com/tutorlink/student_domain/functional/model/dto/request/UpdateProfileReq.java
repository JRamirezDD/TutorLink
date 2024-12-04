package com.tutorlink.student_domain.functional.model.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateProfileReq(
        @NotBlank String username,
        @NotBlank String email
) {
    // Static factory method to create a mock UpdateProfileReq object
    public static UpdateProfileReq mock() {
        return new UpdateProfileReq(
                "mockUsername", // mock username
                "mockEmail@example.com" // mock email
        );
    }
}
