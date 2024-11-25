package com.tutorlink.tutor_domain.functional.messaging.model.dto.resp;

import lombok.Builder;

@Builder
public record MessageResp(
        Long messageId,
        Long senderId,
        Long receiverId,
        String content,
        Long timestamp
) {}

