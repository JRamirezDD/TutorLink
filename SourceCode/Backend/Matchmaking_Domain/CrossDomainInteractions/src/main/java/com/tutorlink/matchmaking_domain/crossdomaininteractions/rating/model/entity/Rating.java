package com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.entity;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.enums.StarRating;

import jakarta.persistence.*;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tutorId;

    @Enumerated(EnumType.STRING) // Store the enum as a string in the database
    private StarRating value; // Change field type to StarRating

    public static Rating fromValue(int value) {
        Rating rating = new Rating();
        rating.setValue(StarRating.fromValue(value)); // Convert int to StarRating
        return rating;
    }

    public StarRating getValue() {
        return value;
    }

    public void setValue(StarRating value) {
        this.value = value;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    public Long getId() {
        return this.id;
    }
}
