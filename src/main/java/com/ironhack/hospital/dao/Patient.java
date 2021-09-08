package com.ironhack.hospital.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@DynamicUpdate
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long id;

    private String name;

    @Column(name = "date_of_birth")
    private LocalDate date;

    @ManyToOne()
    @JoinColumn(name = "admitted_by")
    private Doctor admittedBy;

}
