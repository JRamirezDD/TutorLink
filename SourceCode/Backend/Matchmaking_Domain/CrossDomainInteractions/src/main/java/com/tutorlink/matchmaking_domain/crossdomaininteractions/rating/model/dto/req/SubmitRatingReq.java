package com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubmitRatingReq {
    private Long tutorId;
    private int ratingValue;
}




