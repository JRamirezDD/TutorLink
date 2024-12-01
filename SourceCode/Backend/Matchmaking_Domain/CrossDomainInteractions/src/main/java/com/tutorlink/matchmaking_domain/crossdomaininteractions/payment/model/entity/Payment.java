package com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long studentId;

    @Column(nullable = false)
    private Long tutorId;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private String status; // PENDING, ACCEPTED, REJECTED

    @Column(nullable = false, updatable = false)
    private LocalDateTime requestDate; //timestamp of when the payment request was created

    @Column
    private LocalDateTime paymentDate; //timestamp of when the payment was processed
}



