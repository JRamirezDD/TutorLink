package com.tutorlink.tutor_domain.functional.connectionrequest.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "connections")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long studentId;

    @Column(nullable = false)
    private Long tutorId;

    @Column(nullable = false)
    private String status; // PENDING, ACCEPTED, REJECTED
}

