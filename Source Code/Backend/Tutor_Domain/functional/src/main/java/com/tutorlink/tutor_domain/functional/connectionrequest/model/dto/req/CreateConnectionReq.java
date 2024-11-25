package com.tutorlink.tutor_domain.functional.connectionrequest.model.dto.req;

import jakarta.validation.constraints.NotNull;

public record CreateConnectionReq(
        @NotNull Long studentId,
        @NotNull Long tutorId
) {}

