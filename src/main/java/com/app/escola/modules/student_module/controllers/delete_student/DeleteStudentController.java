package com.app.escola.modules.student_module.controllers.delete_student;

import com.app.escola.modules.student_module.services.delete_student.DeleteStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteStudentController {
    private DeleteStudentService deleteStudentService;

    @Autowired
    public DeleteStudentController(DeleteStudentService deleteStudentService) {
        this.deleteStudentService = deleteStudentService;
    }

    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
        return deleteStudentService.deleteStudent(id);
    }
}
