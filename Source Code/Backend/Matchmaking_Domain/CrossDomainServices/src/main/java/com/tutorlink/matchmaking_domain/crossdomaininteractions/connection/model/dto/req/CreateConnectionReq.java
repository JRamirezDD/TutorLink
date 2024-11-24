package com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.req;

import jakarta.validation.constraints.NotNull;

public record CreateConnectionReq(
        @NotNull Long studentId,
        @NotNull Long tutorId
) {}

