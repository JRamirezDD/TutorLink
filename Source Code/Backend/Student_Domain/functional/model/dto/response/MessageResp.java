package com.tutorlink.student_domain.functional.model.dto.response;

import java.time.LocalDateTime;

public record MessageResp(
        Long messageId,
        Long senderId,
        Long recipientId,
        String content,
        LocalDateTime timestamp
) {}


