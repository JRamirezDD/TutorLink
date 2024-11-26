package com.tutorlink.matchmaking_domain.tutordomainmanager.service_management.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tutor_services")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TutorService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long tutorId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private Double hourlyRate;
}
