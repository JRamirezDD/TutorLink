package com.tutorlink.matchmaking_domain.tutordomainmanager.service_management.service;

import com.tutorlink.matchmaking_domain.tutordomainmanager.service_management.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;

    public Double getAverageRatingForTutor(Long tutorId) {
        return ratingRepository.calculateAverageRating(tutorId);
    }
}

