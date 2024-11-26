package com.tutorlink.student_domain.functional.service;

import com.tutorlink.student_domain.functional.model.dto.request.EnrollmentReq;
import com.tutorlink.student_domain.functional.model.dto.response.CourseCatalogResp;
import com.tutorlink.student_domain.functional.model.dto.response.CourseDetailResp;
import com.tutorlink.student_domain.functional.model.dto.response.EnrollmentStatusResp;
import com.tutorlink.student_domain.functional.model.entity.Course;
import com.tutorlink.student_domain.functional.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatalogService {

    private final CourseRepository courseRepository;

    public List<CourseCatalogResp> getAllCourses(Double minPrice, Double maxPrice, String location, String subject, String sortField, String sortOrder) {
        return courseRepository.findAll().stream()
                .filter(course -> (minPrice == null || course.getHourlyRate() >= minPrice))
                .filter(course -> (maxPrice == null || course.getHourlyRate() <= maxPrice))
                .filter(course -> (location == null || course.getLocation().equalsIgnoreCase(location)))
                .filter(course -> (subject == null || course.getSubject().equalsIgnoreCase(subject)))
                .sorted(getEntityComparator(sortField, sortOrder)) // Sort the entity first
                .map(course -> new CourseCatalogResp(
                        course.getId(),
                        course.getCourseName(),
                        course.getTutor().getName(),
                        course.getTutor().getId(),
                        course.getHourlyRate(),
                        course.getLocation(),
                        course.getSubject(),
                        course.getDescription()))
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
        return List.of(); // Mocked for now
    }

    private Comparator<Course> getEntityComparator(String sortField, String sortOrder) {
        Comparator<Course> comparator;

        switch (sortField.toLowerCase()) {
            case "price":
                comparator = Comparator.comparing(Course::getHourlyRate, Comparator.nullsLast(Double::compareTo));
                break;
            case "location":
                comparator = Comparator.comparing(Course::getLocation, Comparator.nullsLast(String::compareTo));
                break;
            case "subject":
                comparator = Comparator.comparing(Course::getSubject, Comparator.nullsLast(String::compareTo));
                break;
            default:
                comparator = Comparator.comparing(Course::getId, Comparator.nullsLast(Long::compareTo)); // Default sorting
        }

        if ("desc".equalsIgnoreCase(sortOrder)) {
            comparator = comparator.reversed();
        }

        return comparator;
    }



}




