package com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.model.dto.resp;

import lombok.Builder;

@Builder
public record MessageResp(
        Long messageId,
        Long senderId,
        Long receiverId,
        String content,
        Long timestamp
) {}

