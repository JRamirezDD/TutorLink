package com.tutorlink.tutor_domain.functional.profile.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Optional;

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
    private String specialization; // Tutor's field of expertise

    @Column(nullable = true)
    private Double hourlyRate; // Hourly rate for tutoring

    @Column(nullable = true)
    private String description; // Optional description about the tutor

    @Column(nullable = true)
    private String location; // Tutor's location

    // Helper method to handle null safety for optional fields
    public Optional<Double> getHourlyRate() {
        return Optional.ofNullable(hourlyRate);
    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    public Optional<String> getLocation() {
        return Optional.ofNullable(location);
    }
}
