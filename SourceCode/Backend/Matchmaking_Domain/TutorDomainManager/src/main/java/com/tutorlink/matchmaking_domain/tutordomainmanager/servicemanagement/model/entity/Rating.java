package com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.model.entity;

import com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.enums.RatingStars;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ratings")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long tutorId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RatingStars rating;
}


