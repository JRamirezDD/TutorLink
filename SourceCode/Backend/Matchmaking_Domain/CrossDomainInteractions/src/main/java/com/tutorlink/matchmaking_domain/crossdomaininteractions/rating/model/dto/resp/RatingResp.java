package com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.resp;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.enums.StarRating;
import lombok.Builder;

@Builder
public record RatingResp(
        Long id,
        Long tutorId,
        StarRating ratingValue
) {}

