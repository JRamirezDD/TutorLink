package com.tutorlink.student_domain.functional.model.dto.request;

public record MessageReq(
        Long senderId,
        Long recipientId,
        String content
) {}

