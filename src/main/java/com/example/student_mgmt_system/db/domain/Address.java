package com.example.student_mgmt_system.db.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long ID;

    @NotNull
    private String streetName;

    @NotNull
    private int streetNumber;

    @NotNull
    private String municipality;

    @NotNull
    private String city;

    @NotNull
    private String zipcode;

    @NotNull
    private String country;

}
