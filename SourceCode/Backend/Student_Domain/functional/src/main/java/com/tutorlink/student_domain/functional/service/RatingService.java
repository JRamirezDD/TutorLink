package com.tutorlink.student_domain.functional.service;

import com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.repository.RatingRepository;
import com.tutorlink.student_domain.functional.model.enums.Rating;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;

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
}
