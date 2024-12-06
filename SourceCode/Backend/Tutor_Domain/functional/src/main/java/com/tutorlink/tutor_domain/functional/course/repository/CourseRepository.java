package com.tutorlink.tutor_domain.functional.course.repository;

import com.tutorlink.tutor_domain.functional.course.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}

