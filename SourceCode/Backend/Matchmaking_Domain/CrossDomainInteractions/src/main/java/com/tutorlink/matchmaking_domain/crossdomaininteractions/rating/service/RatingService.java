package com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.req.SubmitRatingReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.resp.RatingResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.entity.Rating;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.enums.StarRating;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;

    // Get the average rating for a tutor
    public Double getAverageRatingForTutor(Long tutorId) {
        return ratingRepository.findAverageByTutorId(tutorId);
    }

    // Submit a rating for a tutor
    public RatingResp submitRating(SubmitRatingReq request) {
        // Create a Rating entity from the request DTO
        Rating rating = new Rating();
        rating.setTargetId(request.getTutorId()); // Assuming `targetId` is used for tutorId
        rating.setValue(request.getRatingValue());

        // Save the Rating entity
        rating = ratingRepository.save(rating);

        // Map the saved Rating to a RatingResp DTO
        return RatingResp.builder()
                .id(rating.getId())
                .tutorId(rating.getTargetId()) // Assuming `targetId` represents tutorId
                .ratingValue(StarRating.fromValue(rating.getValue())) // Convert int to StarRating
                .build();
    }
}
