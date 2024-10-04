package com.app.escola.modules.student_module.services.cancelRegistration;

import com.app.escola.data_base.entitys.coursestudent_entity.Coursestudent;
import com.app.escola.data_base.entitys.coursestudent_entity.CoursestudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CancelRegistrationService {
    private CoursestudentRepository coursestudentRepository;

    @Autowired
    public CancelRegistrationService(CoursestudentRepository coursestudentRepository) {
        this.coursestudentRepository = coursestudentRepository;
    }

    public ResponseEntity<String> cancelRegistration(Long id) {
        Optional<Coursestudent> enroll = coursestudentRepository.findById(id);
        if (enroll.isPresent()) {
            coursestudentRepository.deleteById(id);
            return new ResponseEntity<String>("Matricula cancelada!", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Ops... não encontramos essa matrícula!", HttpStatus.BAD_REQUEST);
    }
}
