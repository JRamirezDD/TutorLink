package com.example.tutorlink.controller;

import com.example.tutorlink.model.dto.response.user.CourseResp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Tag(name = "Catalog Controller", description = "Catalog of Courses")
@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Operation(description = "Get all available Courses", summary = "View Course Catalog")
    @GetMapping(
            value = "/courses",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<CourseResp>> getAllCourses() {
        List<CourseResp> courses = Arrays.asList(
                CourseResp.builder()
                        .courseId(1L)
                        .courseName("Introduction to Java")
                        .tutorName("John Doe")
                        .hourlyRate(20.0)
                        .rating(4.5)
                        .build(),
                CourseResp.builder()
                        .courseId(2L)
                        .courseName("Advanced Python")
                        .tutorName("Jane Smith")
                        .hourlyRate(25.0)
                        .rating(4.7)
                        .build()
        );

        return ResponseEntity.ok(courses);
    }

    @Operation(description = "Search courses by Subject", summary = "Search Courses")
    @GetMapping(
            value = "/courses/search",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<CourseResp>> searchCourses(@RequestParam String subject) {
        List<CourseResp> searchResults = Arrays.asList(
                CourseResp.builder()
                        .courseId(3L)
                        .courseName(subject + " Basics")
                        .tutorName("Alice Johnson")
                        .hourlyRate(18.0)
                        .rating(4.8)
                        .build()
        );

        return ResponseEntity.ok(searchResults);
    }
}
