package com.ironhack.hospital.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.hospital.enums.Department;
import com.ironhack.hospital.enums.Status;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@DynamicUpdate
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @Column(name = "employee_id")
    private Long id;

    private String department;

    private String name;

    @NotNull(message = "please enter a valid status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "admittedBy")
    @JsonIgnore
    private List<Patient> patients;


}
