package com.ironhack.hospital.controller.impl;

import com.ironhack.hospital.controller.interfaces.IPatientController;
import com.ironhack.hospital.dao.Doctor;
import com.ironhack.hospital.dao.Patient;
import com.ironhack.hospital.enums.Department;
import com.ironhack.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;


@RestController
public class PatientController implements IPatientController {

    @Autowired
    private PatientRepository patientRepository;


    @GetMapping("/patients")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient getById(@PathVariable(name = "id") Long patientId){

        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        return optionalPatient.isPresent() ?optionalPatient.get() : null;
    }

    @GetMapping("/patients/date")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getByDateBetween(@RequestParam LocalDate date1, @RequestParam LocalDate date2){

    return patientRepository.findByDateBetween(date1, date2);
    }

//    @GetMapping("/patients/department")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Patient> getByDepartment(@RequestParam Optional<String> department){
//    if(department.isPresent()){
//    return patientRepository.findByDepartment(Department.valueOf(department.get().toUpperCase()));
//    }
//    else{
//        return null;
//    }
//    }




}
