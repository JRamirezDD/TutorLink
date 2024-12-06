package com.tutorlink.tutor_domain.functional.course.service;

import com.tutorlink.tutor_domain.functional.course.model.dto.req.CreateCourseReq;
import com.tutorlink.tutor_domain.functional.course.model.dto.resp.CourseResp;
import com.tutorlink.tutor_domain.functional.course.model.entity.Course;
import com.tutorlink.tutor_domain.functional.course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseResp createCourse(CreateCourseReq request) {
        Course course = new Course();
        course.setCourseName(request.getCourseName());
        course.setDescription(request.getDescription());
        course.setHourlyRate(request.getHourlyRate());
        course.setTutorId(request.getTutorId());

        Course savedCourse = courseRepository.save(course);

        return new CourseResp(
                savedCourse.getCourseId(),
                savedCourse.getCourseName(),
                savedCourse.getDescription(),
                savedCourse.getHourlyRate(),
                savedCourse.getTutorId()
        );
    }
}
