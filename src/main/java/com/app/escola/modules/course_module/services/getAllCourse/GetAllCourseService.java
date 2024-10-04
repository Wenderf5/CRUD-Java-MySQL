package com.app.escola.modules.course_module.services.getAllCourse;

import com.app.escola.data_base.entitys.course_entity.Course;
import com.app.escola.data_base.entitys.course_entity.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCourseService {
    private CourseRepository courseRepository;

    @Autowired
    public GetAllCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }
}
