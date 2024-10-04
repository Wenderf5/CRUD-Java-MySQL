package com.app.escola.modules.course_module.services.delete_course;

import com.app.escola.data_base.entitys.course_entity.Course;
import com.app.escola.data_base.entitys.course_entity.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteCourseService {
    private CourseRepository courseRepository;

    @Autowired
    public DeleteCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public ResponseEntity<String> deleteCourse(Long id) {
        try {
            Optional<Course> course = courseRepository.findById(id);
            if (course.isPresent()) {
                courseRepository.deleteById(id);
                return new ResponseEntity<String>("Curso deletado com sucesso!", HttpStatus.OK);
            }
            return new ResponseEntity<String>("Ops... parece que esse curso não existe!", HttpStatus.NOT_FOUND);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<String>("Existem alunos matriculados neste curso. Por favor, remova todos os alunos antes de excluí-lo!", HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao deletar curso!", HttpStatus.BAD_REQUEST);
        }
    }
}
