package com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.entity;

import jakarta.persistence.*;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long targetId;
    private int value;

    public static Rating fromValue(int value) {
        Rating rating = new Rating();
        rating.setValue(value);
        return rating;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }
}







