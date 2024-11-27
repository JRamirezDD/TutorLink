package com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.enums;

import lombok.Getter;

@Getter
public enum RatingStars {
    ONE_STAR(1),
    TWO_STARS(2),
    THREE_STARS(3),
    FOUR_STARS(4),
    FIVE_STARS(5);

    private final int value;

    RatingStars(int value) {
        this.value = value;
    }

    public static RatingStars fromValue(int value) {
        for (RatingStars star : values()) {
            if (star.value == value) {
                return star;
            }
        }
        throw new IllegalArgumentException("Invalid rating value: " + value);
    }
}
