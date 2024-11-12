package com.tutorlink.student_domain.functional.model.dto.response;

import java.time.LocalDateTime;

public record StudentProfileResp(
        Long id,
        String username,
        String email,
        LocalDateTime joinedDate
) {}

