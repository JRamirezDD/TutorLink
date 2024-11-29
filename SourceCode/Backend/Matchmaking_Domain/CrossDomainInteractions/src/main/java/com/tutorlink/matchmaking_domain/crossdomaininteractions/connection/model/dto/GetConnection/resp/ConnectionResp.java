package com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.GetConnection.resp;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.entity.ConnectionStatus;
import lombok.Builder;

@Builder
public record ConnectionResp(
        Long connectionId,
        Long studentId,
        Long tutorId,
        ConnectionStatus status //using enum now instead of string
) {}


