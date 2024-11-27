package com.example.tutorlink.model.dto.request.rating;

public class RatingDTO {

    private Long userId;
    private Long tutorId;
    private int rating;
    private String comment;

    public RatingDTO() {}

    public RatingDTO(Long userId, Long tutorId, int rating, String comment) {
        this.userId = userId;
        this.tutorId = tutorId;
        this.rating = rating;
        this.comment = comment;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
