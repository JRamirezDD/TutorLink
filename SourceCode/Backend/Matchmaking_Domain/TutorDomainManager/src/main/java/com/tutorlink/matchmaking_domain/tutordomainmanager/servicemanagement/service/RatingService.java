package com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.service;

import com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;

    public Double getAverageRatingForTutor(Long tutorId) {
        Double averageRating = ratingRepository.findAverageByTutorId(tutorId);
        return averageRating != null ? averageRating : 0.0;
    }
}

