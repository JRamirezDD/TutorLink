package com.tutorlink.tutor_domain.functional.connectionrequest.model.dto.resp;

import lombok.Builder;

import java.util.List;

@Builder
public record ConnectionListResp(
        List<ConnectionResp> connections
) {}

