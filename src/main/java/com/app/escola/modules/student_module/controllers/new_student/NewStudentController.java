package com.app.escola.modules.student_module.controllers.new_student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.escola.modules.student_module.services.new_student.NewStudentService;

@RestController
class NewStudentController {
    private NewStudentService newStudentService;

    @Autowired
    public NewStudentController(NewStudentService newStudentService) {
        this.newStudentService = newStudentService;
    }

    @PostMapping("/new-student")
    private ResponseEntity<String> newStudent(@RequestBody Student studentBody) {
        return newStudentService.newStudent(studentBody.getCpf(), studentBody.getName());
    }

    private static class Student {
        private String cpf;
        private String name;

        private Student(String name, String cpf) {
            this.cpf = cpf;
            this.name = name;
        }

        //Geters
        private String getCpf() {
            return cpf;
        }

        private String getName() {
            return name;
        }
    }
}
