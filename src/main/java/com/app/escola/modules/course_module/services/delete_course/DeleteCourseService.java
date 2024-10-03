package com.app.escola.modules.course_module.services.delete_course;

import com.app.escola.data_base.entitys.course_entity.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteCourseService {
    private CourseRepository courseRepository;

    @Autowired
    public DeleteCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public ResponseEntity<String> deleteCourse(Long course) {
        try {
            courseRepository.deleteById(course);
            return new ResponseEntity<String>("Curso deletado com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao deletar curso!", HttpStatus.BAD_REQUEST);
        }
    }
}
