package com.tutorlink.student_domain.functional.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.req.SubmitRatingReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.resp.RatingResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.entity.Rating;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.repository.RatingRepository;
import com.tutorlink.student_domain.functional.service.feignclients.Client_CrossDomainInteractions_Rating;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;
    private final Client_CrossDomainInteractions_Rating ratingClient;

    // Save a rating for a student or tutor
    public void submitRating(Long targetId, int ratingValue) {
        Rating rating = Rating.fromValue(ratingValue);
        rating.setTargetId(targetId);
        ratingRepository.save(rating);
    }

    // Retrieve all ratings for a student or tutor
    public List<Rating> getRatings(Long targetId) {
        return ratingRepository.findByTutorId(targetId);
    }

    // Calculate average rating for a student or tutor
    public double getAverageRating(Long targetId) {
        List<Rating> ratings = getRatings(targetId);
        OptionalDouble average = ratings.stream()
                .mapToInt(Rating::getValue)
                .average();

        return average.orElse(0.0);
    }

    // Submit a rating via Feign client
    public RatingResp submitRating(SubmitRatingReq request) {
        return ratingClient.submitRating(request).getBody();
    }

    // Get ratings for a tutor via Feign client
    public List<RatingResp> getRatingsForTutor(Long tutorId) {
        return ratingClient.getRatingsForTutor(tutorId).getBody();
    }
}
