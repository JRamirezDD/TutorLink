package com.tutorlink.tutor_domain.auth.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tutors")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true, length = 100)
    private String email;
}

