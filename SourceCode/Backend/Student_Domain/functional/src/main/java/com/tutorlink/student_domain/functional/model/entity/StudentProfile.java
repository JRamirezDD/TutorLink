package com.tutorlink.student_domain.functional.model.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_profiles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "joined_date", nullable = false, updatable = false)
    private LocalDateTime joinedDate;

    @Column(name = "subscription_plan", length = 20)
    private String subscriptionPlan;

    @Column(name = "subscription_expiry_date")
    private LocalDateTime subscriptionExpiryDate;

    @PrePersist
    protected void onCreate() {
        this.joinedDate = LocalDateTime.now();
    }
}

