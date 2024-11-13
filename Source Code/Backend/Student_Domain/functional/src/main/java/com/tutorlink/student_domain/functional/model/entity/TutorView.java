package com.tutorlink.student_domain.functional.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

//this is to track views for silver students
@Entity
@Table(name = "tutor_views")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TutorView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Column(name = "tutor_id", nullable = false)
    private Long tutorId;

    @Column(name = "date_viewed", nullable = false)
    private LocalDate dateViewed;
}

