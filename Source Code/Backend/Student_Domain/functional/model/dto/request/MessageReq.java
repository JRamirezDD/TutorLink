package com.tutorlink.student_domain.functional.model.dto.request;

public record MessageReq(
        Long senderId,
        Long recipientId,
        String content
) {
    // Static factory method to create a mock MessageReq object
    public static MessageReq mock() {
        return new MessageReq(
                1L, // mock senderId
                2L, // mock recipientId
                "This is a mock message content." // mock content
        );
    }
}
