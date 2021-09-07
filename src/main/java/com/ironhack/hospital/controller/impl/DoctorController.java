package com.ironhack.hospital.controller.impl;

import com.ironhack.hospital.controller.interfaces.IDoctorController;
import com.ironhack.hospital.dao.Doctor;
import com.ironhack.hospital.enums.Department;
import com.ironhack.hospital.enums.Status;
import com.ironhack.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ClientInfoStatus;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
public class DoctorController implements IDoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/doctors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor getById(@PathVariable(name = "id") Long doctorId) {

        Optional<Doctor> optionalDoctor =doctorRepository.findById(doctorId);
        return optionalDoctor.isPresent() ?optionalDoctor.get() : null;
    }

    @GetMapping("/doctors")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

    @GetMapping("/doctors/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> getByStatus(@PathVariable(name = "status") String status) {

        List<Doctor> doctorsByStatus = doctorRepository.findByStatus(Status.valueOf(status.toUpperCase(Locale.ROOT).replace(" ","_")));
        return doctorsByStatus;
    }

    @GetMapping("/doctors/department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> getByDepartment(@PathVariable(name = "department") String department) {

        List<Doctor> doctorsByDepartment = doctorRepository.findByDepartment(Department.valueOf(department.toUpperCase(Locale.ROOT).replace(" ","_")));
        return doctorsByDepartment;
    }


}
