package com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.entity;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.enums.StarRating;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ratings")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long studentId;

    @Column(nullable = false)
    private Long tutorId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StarRating ratingValue;
}






