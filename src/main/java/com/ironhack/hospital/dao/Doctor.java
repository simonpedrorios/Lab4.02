package com.ironhack.hospital.dao;

import com.ironhack.hospital.enums.Department;
import com.ironhack.hospital.enums.Status;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @NotNull(message = "please enter a valid department")
    @Enumerated(EnumType.STRING)
    private Department department;

    private String name;

    @NotNull(message = "please enter a valid status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "id")
    private Set<Patient> patients;


}
