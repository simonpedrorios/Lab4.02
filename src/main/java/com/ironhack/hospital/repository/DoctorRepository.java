package com.ironhack.hospital.repository;

import com.ironhack.hospital.dao.Doctor;
import com.ironhack.hospital.enums.Department;
import com.ironhack.hospital.enums.Status;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findByName(String name);
    Optional<Doctor> findById(Long id);
    List<Doctor> findByStatus(Status stat);
    List<Doctor> findByDepartment(Department dep);
}
