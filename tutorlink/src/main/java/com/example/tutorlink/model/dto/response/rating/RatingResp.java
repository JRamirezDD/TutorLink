package com.example.tutorlink.model.dto.response.rating;

import com.example.tutorlink.model.dto.request.rating.RatingDTO;
import java.util.List;

public class RatingResp {

    private Long tutorId;           // Tutor ID
    private List<RatingDTO> ratings; // List of ratings for the tutor

    // Constructors
    public RatingResp() {}

    public RatingResp(Long tutorId, List<RatingDTO> ratings) {
        this.tutorId = tutorId;
        this.ratings = ratings;
    }

    // Getters and Setters
    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    public List<RatingDTO> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingDTO> ratings) {
        this.ratings = ratings;
    }
}
