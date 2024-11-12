package com.tutorlink.student_domain.functional.service;

import com.tutorlink.student_domain.functional.model.dto.request.EnrollmentReq;
import com.tutorlink.student_domain.functional.model.dto.response.CourseCatalogResp;
import com.tutorlink.student_domain.functional.model.dto.response.CourseDetailResp;
import com.tutorlink.student_domain.functional.model.dto.response.EnrollmentStatusResp;
import com.tutorlink.student_domain.functional.model.entity.Course;
import com.tutorlink.student_domain.functional.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatalogService {

    private final CourseRepository courseRepository;

    public List<CourseCatalogResp> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(course -> new CourseCatalogResp(
                        course.getId(),
                        course.getCourseName(),
                        course.getTutor().getName(),
                        course.getTutor().getId(),
                        course.getHourlyRate()))
                .collect(Collectors.toList());
    }

    public CourseDetailResp getCourseDetails(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        return new CourseDetailResp(
                course.getId(),
                course.getCourseName(),
                course.getTutor().getName(),
                course.getTutor().getId(),
                course.getHourlyRate(),
                course.getDescription() // Include description in detailed view
        );
    }

    public EnrollmentStatusResp enrollInCourse(Long courseId, EnrollmentReq enrollmentReq) {
        // TODO: enrollment logic

        return new EnrollmentStatusResp(courseId, enrollmentReq.studentId(), "ENROLLED");
    }

    public List<CourseCatalogResp> getEnrolledCourses(Long studentId) {
        // TODO: logic to get all enrolled courses

        return List.of();
    }
}



