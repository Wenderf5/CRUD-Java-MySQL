package com.app.escola.modules.student_module.controllers.getAllAlunos;

import com.app.escola.modules.student_module.services.getAllStudent.GetAllStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAllAlunosController {
    private GetAllStudentService getAllStudentService;

    @Autowired
    public GetAllAlunosController(GetAllStudentService getAllStudentService) {
        this.getAllStudentService = getAllStudentService;
    }

    @GetMapping("/get-all-student")
    public ResponseEntity getAllStudent(){
        return getAllStudentService.getAllStudent();
    }
}
