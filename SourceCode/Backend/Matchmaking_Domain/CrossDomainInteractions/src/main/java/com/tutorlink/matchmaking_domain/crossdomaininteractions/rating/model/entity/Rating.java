package com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ratings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long tutorId;

    @Column(nullable = false)
    private Long studentId;

    @Column(nullable = false)
    private int ratingValue; // Changed from StarRating to int
}






