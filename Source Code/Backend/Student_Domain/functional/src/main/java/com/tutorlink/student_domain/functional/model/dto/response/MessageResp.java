package com.tutorlink.student_domain.functional.model.dto.response;

import java.time.LocalDateTime;

public record MessageResp(
        Long messageId,
        Long senderId,
        Long recipientId,
        String content,
        LocalDateTime timestamp
) {
    // Static factory method to create a mock MessageResp object
    public static MessageResp mock() {
        return new MessageResp(
                1L, // mock messageId
                2L, // mock senderId
                3L, // mock recipientId
                "This is a mock message content.", // mock content
                LocalDateTime.now() // mock timestamp
        );
    }
}