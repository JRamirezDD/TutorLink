package com.tutorlink.student_domain.functional.graphQl;

import com.tutorlink.student_domain.functional.model.dto.response.CourseCatalogResp;
import com.tutorlink.student_domain.functional.model.dto.response.CourseDetailResp;
import com.tutorlink.student_domain.functional.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GraphQlResolver {

    private final CatalogService catalogService;

    public List<CourseCatalogResp> courses(Double minPrice, Double maxPrice, String location, String subject, String sortField, String sortOrder) {
        return catalogService.getAllCourses(minPrice, maxPrice, location, subject, sortField, sortOrder);
    }

    public CourseDetailResp courseDetails(Long courseId) {
        return catalogService.getCourseDetails(courseId);
    }

    public List<CourseCatalogResp> enrolledCourses(Long studentId) {
        return catalogService.getEnrolledCourses(studentId);
    }
}

