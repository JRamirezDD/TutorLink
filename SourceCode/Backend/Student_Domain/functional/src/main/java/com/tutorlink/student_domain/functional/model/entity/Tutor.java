package com.tutorlink.student_domain.functional.model.entity;


import jakarta.persistence.*;
import lombok.*;

/*
*  WILL LATER BE CHANGED WHEN I GET TO THE TUTOR DOMAIN!!
* */

@Entity
@Table(name = "tutors")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;
}

