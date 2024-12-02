package com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.model.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SendMessageReq(
        @NotNull Long senderId,
        @NotNull Long receiverId,
        @NotBlank String content,
        @NotBlank Long timestamp
) {}

