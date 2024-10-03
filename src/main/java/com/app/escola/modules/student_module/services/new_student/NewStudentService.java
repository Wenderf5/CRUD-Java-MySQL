package com.app.escola.modules.student_module.services.new_student;

import com.app.escola.data_base.entitys.student_entity.StudentRepository;
import com.app.escola.data_base.entitys.student_entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class NewStudentService {
    private StudentRepository studentRepository;

    @Autowired
    public NewStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ResponseEntity<String> newStudent(String cpf, String name) {
        try {
            Student student = new Student(cpf, name);
            studentRepository.save(student);
            return new ResponseEntity("Aluno cadastrado com sucesso!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity("Erro ao cadastrar aluno!", HttpStatus.BAD_REQUEST);
        }
    }
}
