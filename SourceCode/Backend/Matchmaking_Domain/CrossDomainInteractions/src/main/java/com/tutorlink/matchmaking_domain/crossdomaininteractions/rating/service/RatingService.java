package com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.req.SubmitRatingReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.resp.RatingResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.entity.Rating;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.enums.StarRating;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;

    // Method to get the average rating for a tutor
    public Double getAverageRatingForTutor(Long tutorId) {
        return ratingRepository.findAverageByTutorId(tutorId);
    }

    // Method to submit a rating
    public RatingResp submitRating(SubmitRatingReq request) {
        Rating rating = Rating.builder()
                .studentId(request.getStudentId())
                .tutorId(request.getTutorId())
                .ratingValue(StarRating.fromValue(request.getRatingValue()))
                .build();

        rating = ratingRepository.save(rating);

        return RatingResp.builder()
                .id(rating.getId())
                .studentId(rating.getStudentId())
                .tutorId(rating.getTutorId())
                .ratingValue(rating.getRatingValue())
                .build();
    }

    // Method to get all ratings for a tutor
    public List<RatingResp> getRatingsForTutor(Long tutorId) {
        return ratingRepository.findByTutorId(tutorId).stream()
                .map(rating -> RatingResp.builder()
                        .id(rating.getId())
                        .studentId(rating.getStudentId())
                        .tutorId(rating.getTutorId())
                        .ratingValue(rating.getRatingValue())
                        .build())
                .collect(Collectors.toList());
    }
}




