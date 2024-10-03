package com.app.escola.modules.course_module.controllers.delete_course;

import com.app.escola.modules.course_module.services.delete_course.DeleteCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DeleteCourseController {
    private DeleteCourseService deleteCourseService;

    @Autowired
    public DeleteCourseController(DeleteCourseService deleteCourseService) {
        this.deleteCourseService = deleteCourseService;
    }

    @DeleteMapping("/delete-course/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id") Long id) {
        return deleteCourseService.deleteCourse(id);
    }
}
