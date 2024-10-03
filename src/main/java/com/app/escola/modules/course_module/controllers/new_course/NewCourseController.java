package com.app.escola.modules.course_module.controllers.new_course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.escola.modules.course_module.services.new_course.NewCourseService;

@RestController
class NewCourseController {
    private NewCourseService newCourseService;

    @Autowired
    public NewCourseController(NewCourseService newCourseService) {
        this.newCourseService = newCourseService;
    }

    @PostMapping("/new-course")
    private ResponseEntity<String> newCourse(@RequestBody Course courseBody) {
        return newCourseService.newCourse(courseBody.getCourseName());
    }

    private static class Course {
        private String courseName;

        //Construtor padrão sem argumentos para desserialização
        public Course(){
        }

        public Course(String courseName) {
            this.courseName = courseName;
        }

        //Geters
        public String getCourseName() {
            return courseName;
        }
    }
}
