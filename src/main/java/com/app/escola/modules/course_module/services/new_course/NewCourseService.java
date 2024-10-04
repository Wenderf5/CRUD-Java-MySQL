package com.app.escola.modules.course_module.services.new_course;

import com.app.escola.data_base.entitys.course_entity.CourseRepository;
import com.app.escola.data_base.entitys.course_entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class NewCourseService {
    private CourseRepository courseRepository;

    @Autowired
    public NewCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public ResponseEntity<String> newCourse(String course) {
        try {
            Course newCourse = new Course(course);
            courseRepository.save(newCourse);
            return new ResponseEntity("Curso criado com sucesso!", HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity("Este curso já está cadastrado!", HttpStatus.CONFLICT);
        }catch (Exception e){
            return new ResponseEntity("Erro ao cadastrar curso!", HttpStatus.BAD_REQUEST);
        }
    }
}
