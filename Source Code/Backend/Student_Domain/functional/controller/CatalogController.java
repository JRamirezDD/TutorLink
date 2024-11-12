package com.tutorlink.student_domain.functional.controller;

import com.tutorlink.student_domain.functional.model.dto.request.EnrollmentReq;
import com.tutorlink.student_domain.functional.model.dto.response.CourseCatalogResp;
import com.tutorlink.student_domain.functional.model.dto.response.CourseDetailResp;
import com.tutorlink.student_domain.functional.model.dto.response.EnrollmentStatusResp;
import com.tutorlink.student_domain.functional.service.CatalogService;
import com.tutorlink.student_domain.functional.service.RatingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;
    private final RatingService ratingService;

    //get all courses in catalog
    @Operation(summary = "Get all courses in catalog", description = "Returns list of available courses with basic info.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of courses",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseCatalogResp.class),
                            examples = @ExampleObject(value = "[{\"courseId\": 1, \"courseName\": \"Computer Science Fundamentals\", \"tutorName\": \"Jorge Ramirez\", \"tutorId\": 2, \"hourlyRate\": 25.0, \"description\": \"Fundamentals of computer science.\"}]")
                    ))
    })
    @GetMapping("/courses")
    public ResponseEntity<List<CourseCatalogResp>> getAllCourses() {
        List<CourseCatalogResp> courses = catalogService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    //view course info
    @Operation(summary = "View course information", description = "Retrieves more detailed info for a specific course by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Course details",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseDetailResp.class),
                            examples = @ExampleObject(value = "{\"courseId\": 2, \"courseName\": \"HCI\", \"tutorName\": \"Marcos Gonzalez\", \"tutorId\": 4, \"hourlyRate\": 35.0, \"description\": \"Exploration of interactions between people and computers.\"}")
                    )),
            @ApiResponse(responseCode = "404", description = "Course not found")
    })
    @GetMapping("/courses/{courseId}")
    public ResponseEntity<CourseDetailResp> getCourseDetails(@PathVariable Long courseId) {
        CourseDetailResp courseDetails = catalogService.getCourseDetails(courseId);
        return ResponseEntity.ok(courseDetails);
    }

    //enroll in a course
    @Operation(summary = "Enroll in a course", description = "Enrolls the student in a course by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Enrollment status",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EnrollmentStatusResp.class),
                            examples = @ExampleObject(value = "{\"courseId\": 1, \"studentId\": 3, \"status\": \"ENROLLED\"}")
                    )),
            @ApiResponse(responseCode = "400", description = "Enrollment failed due to invalid request")
    })
    @PostMapping("/courses/{courseId}/enroll")
    public ResponseEntity<EnrollmentStatusResp> enrollInCourse(@PathVariable Long courseId, @RequestBody EnrollmentReq enrollmentReq) {
        EnrollmentStatusResp status = catalogService.enrollInCourse(courseId, enrollmentReq);
        return ResponseEntity.ok(status);
    }

    //see enrolled courses
    @Operation(summary = "See enrolled courses", description = "Lists all courses the student is enrolled in.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of enrolled courses",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseCatalogResp.class),
                            examples = @ExampleObject(value = "[{\"courseId\": 1, \"courseName\": \"Computer Science Fundamentals\", \"tutorName\": \"Jorge Ramirez\", \"tutorId\": 2, \"hourlyRate\": 25.0, \"description\": \"Fundamentals of computer science.\"}]")
                    )),
            @ApiResponse(responseCode = "400", description = "Invalid student ID")
    })
    @GetMapping("/enrolled")
    public ResponseEntity<List<CourseCatalogResp>> getEnrolledCourses(@RequestParam Long studentId) {
        List<CourseCatalogResp> enrolledCourses = catalogService.getEnrolledCourses(studentId);
        return ResponseEntity.ok(enrolledCourses);
    }
}



