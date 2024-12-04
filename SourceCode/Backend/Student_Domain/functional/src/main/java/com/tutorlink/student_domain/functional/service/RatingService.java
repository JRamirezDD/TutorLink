package com.tutorlink.student_domain.functional.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.req.SubmitRatingReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.resp.RatingResp;
import com.tutorlink.student_domain.functional.service.feignclients.Client_CrossDomainInteractions_Rating;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    // save a rating for a student or tutor
    public void submitRating(Long targetId, int ratingValue) {
        Rating rating = Rating.fromValue(ratingValue);
        ratingRepository.save(targetId, rating);
    }

    // retrieve all ratings for a student or tutor
    public List<Rating> getRatings(Long targetId) {
        return ratingRepository.findByTargetId(targetId);
    }

    // calculate average rating for a student or tutor
    public double getAverageRating(Long targetId) {
        List<Rating> ratings = getRatings(targetId);
        OptionalDouble average = ratings.stream()
                .mapToInt(Rating::getValue)
                .average();

        return average.orElse(0.0);
    }

    private final Client_CrossDomainInteractions_Rating ratingClient;

    public RatingResp submitRating(SubmitRatingReq request) {
        return ratingClient.submitRating(request).getBody();
    }

    public List<RatingResp> getRatingsForTutor(Long tutorId) {
        return ratingClient.getRatingsForTutor(tutorId).getBody();
    }
}