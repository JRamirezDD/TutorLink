package com.tutorlink.student_domain.functional.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SendMessageReq(
        @NotNull Long senderId,
        @NotNull Long recipientId,
        @NotBlank String content
) {
    // Static factory method to create a mock SendMessageReq object
    public static SendMessageReq mock() {
        return new SendMessageReq(
                1L, // mock senderId
                2L, // mock recipientId
                "This is a mock message content." // mock content
        );
    }
}