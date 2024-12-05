package com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.req.SubmitRatingReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.resp.RatingResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.entity.Rating;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.enums.StarRating;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;

    // Submit a rating for a tutor
    public RatingResp submitRating(SubmitRatingReq request) {
        // Convert the integer rating value to StarRating
        StarRating starRating = StarRating.fromValue(request.getRatingValue());

        // Create and populate the Rating entity
        Rating rating = new Rating();
        rating.setTutorId(request.getTutorId());
        rating.setValue(starRating);

        // Save the rating to the repository
        rating = ratingRepository.save(rating);

        // Build and return the RatingResp DTO
        return RatingResp.builder()
                .id(rating.getId())
                .tutorId(rating.getTutorId())
                .ratingValue(rating.getValue()) // This is now StarRating
                .build();
    }

    // Get the average rating for a tutor
    public Double getAverageRatingForTutor(Long tutorId) {
        Double average = ratingRepository.findAverageByTutorId(tutorId);
        return average;
    }
}
