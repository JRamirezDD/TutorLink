package com.tutorlink.tutor_domain.functional.course.model.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseResp {
    private Long courseId;
    private String courseName;
    private String description;
    private Double hourlyRate;
    private Long tutorId;
}
