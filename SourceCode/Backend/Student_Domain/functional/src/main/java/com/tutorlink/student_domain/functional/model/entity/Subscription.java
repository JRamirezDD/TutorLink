package com.tutorlink.student_domain.functional.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "subscriptions")
@Getter
@Setter
@NoArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id", nullable = false, unique = true)
    private Long studentId;

    @Column(nullable = false)
    private String plan = "Silver"; // Default plan is "Silver"

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate = LocalDateTime.now();

    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;

    public Subscription(Long studentId, String plan, LocalDateTime startDate, LocalDateTime expiryDate) {
        this.studentId = studentId;
        this.plan = plan;
        this.startDate = startDate;
        this.expiryDate = expiryDate;
    }
}

