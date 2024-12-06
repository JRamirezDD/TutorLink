package com.tutorlink.student_domain.functional.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.req.SubmitRatingReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.resp.RatingResp;
import com.tutorlink.student_domain.functional.service.feignclients.Client_CrossDomainInteractions_Rating;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final Client_CrossDomainInteractions_Rating ratingClient;

    // Submit a rating via Feign client
    public RatingResp submitRating(SubmitRatingReq request) {
        return ratingClient.submitRating(request).getBody();
    }

    // Get average rating for a tutor via Feign client
    public Double getAverageRatingForTutor(Long tutorId) {
        return ratingClient.getAverageRatingForTutor(tutorId).getBody();
    }
}
