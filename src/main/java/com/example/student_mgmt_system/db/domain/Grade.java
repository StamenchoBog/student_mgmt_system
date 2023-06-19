package com.example.student_mgmt_system.db.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    private Integer grade;

    @NotNull
    private LocalDate date;

    @NotNull
    @OneToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @NotNull
    @OneToOne
    @JoinColumn(name = "student_person_id", nullable = false)
    private Student student;

    @NotNull
    @OneToOne
    @JoinColumn(name = "educator_person_id", nullable = false)
    private Educator educator;
}
