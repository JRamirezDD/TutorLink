package com.tutorlink.student_domain.functional.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
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

    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Column(name = "payment_request_id", nullable = false)
    private Long paymentRequestId;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private String status; // PENDING, PAID, or DECLINED

    @Column(name = "request_date", nullable = false)
    private LocalDateTime requestDate;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;
}
