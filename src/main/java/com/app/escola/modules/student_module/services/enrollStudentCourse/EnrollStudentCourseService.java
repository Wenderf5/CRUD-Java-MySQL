package com.app.escola.modules.student_module.services.enrollStudentCourse;

import com.app.escola.data_base.entitys.coursestudent_entity.Coursestudent;
import com.app.escola.data_base.entitys.coursestudent_entity.CoursestudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EnrollStudentCourseService {
    private CoursestudentRepository courseStudentRepository;

    @Autowired
    public EnrollStudentCourseService(CoursestudentRepository courseStudentRepository) {
        this.courseStudentRepository = courseStudentRepository;
    }

    public ResponseEntity enrollStudent(Long id_course, Long id_student) {
        try {
            Coursestudent enroll = new Coursestudent(id_course, id_student);
            courseStudentRepository.save(enroll);
            return new ResponseEntity<String>("Matricula realizada com sucesso!", HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<String>("O aluno já está matriculado nesse curso!", HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao realizar matricula!", HttpStatus.BAD_REQUEST);
        }
    }
}
