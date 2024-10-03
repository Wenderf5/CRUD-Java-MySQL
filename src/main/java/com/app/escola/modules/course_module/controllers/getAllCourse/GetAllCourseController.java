package com.app.escola.modules.course_module.controllers.getAllCourse;

import com.app.escola.data_base.entitys.course_entity.Course;
import com.app.escola.modules.course_module.services.getAllCourse.GetAllCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class GetAllCourseController {
    private GetAllCourseService getAllCoursesService;

    @Autowired
    public GetAllCourseController(GetAllCourseService getAllCoursesService) {
        this.getAllCoursesService = getAllCoursesService;
    }

    @GetMapping("/get-all-course")
    public List<Course> getAllCourses() {
        return getAllCoursesService.getAllCourse();
    }
}
