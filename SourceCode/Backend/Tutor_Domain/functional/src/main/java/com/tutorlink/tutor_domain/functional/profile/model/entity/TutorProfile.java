package com.tutorlink.tutor_domain.functional.profile.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tutor_profiles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TutorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String specialization; //Tutor's field of expertise

    @Column(nullable = false)
    private Double hourlyRate; //hourly rate for tutoring

    @Column(nullable = true)
    private String description; //optional description about the tutor

    @Column(nullable = true)
    private String location; //tutor's location
}

