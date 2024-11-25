package com.tutorlink.tutor_domain.functional.ratingviewer.model.entity;

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

    @Column(nullable = false)
    private Long studentId;

    @Column(nullable = false)
    private Double rating;

    @Column(length = 500)
    private String comment; // Optional comment about the tutor
}

