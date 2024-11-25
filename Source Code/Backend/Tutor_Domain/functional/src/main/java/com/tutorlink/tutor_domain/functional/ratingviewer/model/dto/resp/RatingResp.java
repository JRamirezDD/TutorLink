package com.tutorlink.tutor_domain.functional.ratingviewer.model.dto.resp;

import lombok.Builder;

@Builder
public record RatingResp(
        Long ratingId,
        Long tutorId,
        Long studentId,
        Double rating,
        String comment
) {}

