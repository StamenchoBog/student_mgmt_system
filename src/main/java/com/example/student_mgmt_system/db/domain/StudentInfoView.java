package com.example.student_mgmt_system.db.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Immutable;

import java.sql.Date;

@Entity(name = "student_info")
@Immutable
public class StudentInfoView {

    @Id
    @NotNull
    private Long studentId;

    @NotNull
    private String studentName;

    @NotNull
    private Date dateOfBirth;

    @NotNull
    private String embg;

    @NotNull
    private String email;

    @NotNull
    private String major;

    @NotNull
    private Long scholarshipAmount;

    @NotNull
    private Date scholarshipExpirationDate;

    public Long getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmbg() {
        return embg;
    }

    public String getEmail() {
        return email;
    }

    public String getMajor() {
        return major;
    }

    public Long getScholarshipAmount() {
        return scholarshipAmount;
    }

    public Date getScholarshipExpirationDate() {
        return scholarshipExpirationDate;
    }
}
