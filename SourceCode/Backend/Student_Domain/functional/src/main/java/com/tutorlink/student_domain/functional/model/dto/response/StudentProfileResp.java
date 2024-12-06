package com.tutorlink.student_domain.functional.model.dto.response;


public record StudentProfileResp(
        Long id,
        String username,
        String email,
        String subscriptionLevel // Add this field
) {
    // Static factory method to create a mock StudentProfileResp object
    public static StudentProfileResp mock() {
        return new StudentProfileResp(
                1L, // mock id
                "mockUsername", // mock username
                "mockEmail@example.com", // mock email
                "Gold" // mock subscription level
        );
    }


}
