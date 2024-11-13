package com.tutorlink.student_domain.functional.repository;


import com.tutorlink.student_domain.functional.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}

