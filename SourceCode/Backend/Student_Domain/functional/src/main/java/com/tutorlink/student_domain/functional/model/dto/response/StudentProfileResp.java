package com.tutorlink.student_domain.functional.model.dto.response;

import java.time.LocalDateTime;

public record StudentProfileResp(
        Long id,
        String username,
        String email,
        LocalDateTime joinedDate
) {
    // Static factory method to create a mock StudentProfileResp object
    public static StudentProfileResp mock() {
        return new StudentProfileResp(
                1L, // mock id
                "mockUsername", // mock username
                "mockEmail@example.com", // mock email
                LocalDateTime.now() // mock joinedDate
        );
    }
}