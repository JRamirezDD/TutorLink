package com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.GetConnection.resp;

import lombok.Builder;

@Builder
public record ConnectionResp(
        Long connectionId,
        Long studentId,
        Long tutorId,
        String status
) {}

