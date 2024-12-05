package com.tutorlink.tutor_domain.functional.course.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double hourlyRate;

    @Column(nullable = false)
    private Long tutorId; // Foreign key to associate with a tutor
}
