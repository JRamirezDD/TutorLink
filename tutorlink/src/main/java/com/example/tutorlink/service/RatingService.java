package com.example.tutorlink.service;


import com.example.tutorlink.model.dto.request.rating.RatingDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingService {

    private List<RatingDTO> ratings = new ArrayList<>();

    public void submitRating(RatingDTO ratingDTO) {
        ratings.add(ratingDTO);
    }

    public List<RatingDTO> getRatingsByTutor(Long tutorId) {
        List<RatingDTO> tutorRatings = new ArrayList<>();

        for (RatingDTO rating : ratings) {
            if (rating.getTutorId().equals(tutorId)) {
                tutorRatings.add(rating);
            }
        }

        return tutorRatings;
    }
}

