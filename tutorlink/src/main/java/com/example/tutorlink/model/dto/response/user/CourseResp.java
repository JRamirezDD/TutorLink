package com.example.tutorlink.model.dto.response.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CourseResp {
    private Long courseId;
    private String courseName;
    private String tutorName;
    private Double hourlyRate;
    private Double rating;
}
