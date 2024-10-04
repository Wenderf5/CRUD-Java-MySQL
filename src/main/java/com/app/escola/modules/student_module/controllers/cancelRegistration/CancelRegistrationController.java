package com.app.escola.modules.student_module.controllers.cancelRegistration;

import com.app.escola.modules.student_module.services.cancelRegistration.CancelRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CancelRegistrationController {
    private CancelRegistrationService cancelRegistrationServicea;

    @Autowired
    public CancelRegistrationController(CancelRegistrationService cancelRegistrationServicea) {
        this.cancelRegistrationServicea = cancelRegistrationServicea;
    }

    @DeleteMapping("/cancel-registration/{id}")
    public ResponseEntity<String> cancelRegistration(@PathVariable("id") Long id) {
        return cancelRegistrationServicea.cancelRegistration(id);
    }
}
