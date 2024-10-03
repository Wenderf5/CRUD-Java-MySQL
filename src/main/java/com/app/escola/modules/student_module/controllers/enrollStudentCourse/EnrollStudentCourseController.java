package com.app.escola.modules.student_module.controllers.enrollStudentCourse;

import com.app.escola.modules.student_module.services.enrollStudentCourse.EnrollStudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollStudentCourseController {
    private EnrollStudentCourseService enrollStudentCourseService;

    @Autowired
    public EnrollStudentCourseController(EnrollStudentCourseService enrollStudentCourseService) {
        this.enrollStudentCourseService = enrollStudentCourseService;
    }

    @PatchMapping("/enroll-student")
    public ResponseEntity enrollStudent(@RequestBody Enroll enroll) {
        return enrollStudentCourseService.enrollStudent(enroll.getId_coursr(), enroll.getId_student());
    }

    public static class Enroll {
        private Long id_course;
        private Long id_student;

        public Enroll(Long id_course, Long id_student) {
            this.id_course = id_course;
            this.id_student = id_student;
        }

        public Long getId_coursr() {
            return id_course;
        }

        public Long getId_student() {
            return id_student;
        }
    }
}
