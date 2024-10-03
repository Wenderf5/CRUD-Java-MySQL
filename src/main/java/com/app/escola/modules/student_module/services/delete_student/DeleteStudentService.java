package com.app.escola.modules.student_module.services.delete_student;

import com.app.escola.data_base.entitys.student_entity.StudentRepository;
import com.app.escola.data_base.entitys.student_entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteStudentService {
    private StudentRepository studentRepository;

    @Autowired
    public DeleteStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ResponseEntity<String> deleteStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.deleteById(id);
            return new ResponseEntity<String>("Aluno deletado com sucesso!", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Erro ao deletar aluno!", HttpStatus.BAD_REQUEST);
    }
}

