package com.example.student_mgmt_system.db.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    @Column(name = "street_name")
    private String streetName;

    @NotNull
    @Column(name = "street_number")
    private int streetNumber;

    @NotNull
    private String municipality;

    @NotNull
    private String city;

    @NotNull
    private String zipcode;

    @NotNull
    private String country;

    // Static defined getters and setters methods to be used with Thymeleaf

    public Long getId() {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setId(Long ID) {
        this.id = ID;
    };
}
