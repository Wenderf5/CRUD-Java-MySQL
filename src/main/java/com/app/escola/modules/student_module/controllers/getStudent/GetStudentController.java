package com.app.escola.modules.student_module.controllers.getStudent;

import com.app.escola.modules.student_module.services.getStudent.GetStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetStudentController {
    private GetStudentService getStudentService;

    @Autowired
    public GetStudentController(GetStudentService getStudentService) {
        this.getStudentService = getStudentService;
    }

    @GetMapping("/get-student/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") Long id) {
        return getStudentService.getStudent(id);
    }
}
