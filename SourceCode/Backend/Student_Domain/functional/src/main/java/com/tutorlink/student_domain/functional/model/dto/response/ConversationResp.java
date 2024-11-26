package com.tutorlink.student_domain.functional.model.dto.response;

public record ConversationResp(
        Long otherUserId,
        String otherUserName
) {
    // Static factory method to create a mock ConversationResp object
    public static ConversationResp mock() {
        return new ConversationResp(
                1L, // mock otherUserId
                "mockUserName" // mock otherUserName
        );
    }
}
