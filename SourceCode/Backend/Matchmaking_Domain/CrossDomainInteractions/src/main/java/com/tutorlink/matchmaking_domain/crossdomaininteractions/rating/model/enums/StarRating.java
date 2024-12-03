package com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.enums;

import lombok.Getter;

@Getter
public enum StarRating {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private final int value;

    StarRating(int value) {
        this.value = value;
    }

    public static StarRating fromValue(int value) {
        for (StarRating rating : values()) {
            if (rating.getValue() == value) {
                return rating;
            }
        }
        throw new IllegalArgumentException("Invalid rating value: " + value);
    }
}



