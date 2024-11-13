package com.tutorlink.student_domain.functional.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SendMessageReq(
        @NotNull Long senderId,
        @NotNull Long recipientId,
        @NotBlank String content
) {}


