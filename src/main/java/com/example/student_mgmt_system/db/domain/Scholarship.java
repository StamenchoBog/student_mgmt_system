package com.example.student_mgmt_system.db.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.math.BigInteger;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "scholarship")
public class Scholarship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private BigInteger amount;

    @NotNull
    private LocalDate received_date;

    @NotNull
    private LocalDate expiration_date;
}
