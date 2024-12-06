package com.tutorlink.tutor_domain.functional.course.model.dto.req;

import lombok.Data;

@Data
public class CreateCourseReq {
    private String courseName;
    private String description;
    private Double hourlyRate;
    private Long tutorId; //associate course with tutor
}
