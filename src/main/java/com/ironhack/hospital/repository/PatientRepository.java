package com.ironhack.hospital.repository;

import com.ironhack.hospital.dao.Patient;
import com.ironhack.hospital.enums.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByName(String name);
    List<Patient> findByDateBetween(LocalDate date1, LocalDate date2);
//    List<Patient> findByAd(Department department);


}
