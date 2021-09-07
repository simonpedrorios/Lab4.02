package com.ironhack.hospital.controller.interfaces;

import com.ironhack.hospital.dao.Doctor;
import com.ironhack.hospital.dao.Patient;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface IPatientController {

    Patient getById(Long id);
}
