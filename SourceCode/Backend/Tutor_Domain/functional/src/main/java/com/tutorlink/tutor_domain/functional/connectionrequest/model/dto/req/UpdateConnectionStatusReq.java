package com.tutorlink.tutor_domain.functional.connectionrequest.model.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateConnectionStatusReq(
        @NotNull Long connectionId,
        @NotBlank String status // ACCEPTED or REJECTED
) {}

