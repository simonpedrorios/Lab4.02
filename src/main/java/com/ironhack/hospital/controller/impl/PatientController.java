package com.ironhack.hospital.controller.impl;

import com.ironhack.hospital.controller.interfaces.IPatientController;
import com.ironhack.hospital.dao.Doctor;
import com.ironhack.hospital.dao.Patient;
import com.ironhack.hospital.enums.Department;
import com.ironhack.hospital.enums.Status;
import com.ironhack.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;


@RestController
@RequestMapping("patients")
public class PatientController implements IPatientController {

    @Autowired
    private PatientRepository patientRepository;


    @GetMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient getById(@PathVariable(name = "id") Long patientId){

        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        return optionalPatient.isPresent() ?optionalPatient.get() : null;
    }

    @GetMapping("/between/{start}/{end}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getByDateBetween(@PathVariable(name = "start") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start, @PathVariable(name = "end") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){

    return patientRepository.findByDateBetween(start, end);
    }

    @GetMapping("/doctor/{department}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Patient> getByDepartment(@PathVariable(name = "department") String department){
    if(!department.isEmpty()){
    return patientRepository.findByAdmittedByDepartment(department);
    }
    else{
        return null;
    }
    }

    @GetMapping("/doctor-status/{status}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Patient> getByDoctorByStatus(@PathVariable(name = "status") String status){
        if(!status.isEmpty()){
            return patientRepository.findByAdmittedByStatus(Status.valueOf(status.toUpperCase()));
        }
        else {
            return null;
        }
    }






}
