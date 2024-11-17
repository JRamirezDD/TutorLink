package com.tutorlink.student_domain.functional.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorlink.student_domain.functional.model.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}

