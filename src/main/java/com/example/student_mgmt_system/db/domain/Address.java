package com.example.student_mgmt_system.db.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    private String street_name;

    @NotNull
    private Integer street_number;

    @NotNull
    private String municipality;

    @NotNull
    private String city;

    @NotNull
    private Integer zipcode;

    @NotNull
    private String country;

    // Static defined getters and setters methods to be used with Thymeleaf
    public @NotNull Long getId() {
        return id;
    }

    public String getStreetName() {
        return street_name;
    }

    public int getStreetNumber() {
        return street_number;
    }

    public @NotNull String getMunicipality() {
        return municipality;
    }

    public @NotNull String getCity() {
        return city;
    }

    public @NotNull Integer getZipcode() {
        return zipcode;
    }

    public @NotNull String getCountry() {
        return country;
    }

    public void setId(@NotNull Long ID) {
        this.id = ID;
    };

    public void setStreet_name(@NotNull String street_name) {
        this.street_name = street_name;
    }

    public void setStreet_number(@NotNull Integer street_number) {
        this.street_number = street_number;
    }

    public void setMunicipality(@NotNull String municipality) {
        this.municipality = municipality;
    }

    public void setCity(@NotNull String city) {
        this.city = city;
    }

    public void setZipcode(@NotNull Integer zipcode) {
        this.zipcode = zipcode;
    }

    public void setCountry(@NotNull String country) {
        this.country = country;
    }
}
