package com.tutorlink.student_domain.functional.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.req.SubmitRatingReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.resp.RatingResp;
import com.tutorlink.student_domain.functional.service.feignclients.Client_CrossDomainInteractions_Rating;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final Client_CrossDomainInteractions_Rating ratingClient;

    public RatingResp submitRating(SubmitRatingReq request) {
        return ratingClient.submitRating(request).getBody();
    }

    public List<RatingResp> getRatingsForTutor(Long tutorId) {
        return ratingClient.getRatingsForTutor(tutorId).getBody();
    }
}


