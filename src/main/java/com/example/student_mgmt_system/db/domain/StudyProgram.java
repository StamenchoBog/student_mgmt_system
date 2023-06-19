package com.example.student_mgmt_system.db.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name = "study_program")
public class StudyProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long ID;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private Integer required_credits;

    @NotNull
    private LocalDate start_date;

    @NotNull
    private LocalDate end_date;

    @ManyToMany
    @JoinTable(
        name = "study_program_course",
        joinColumns = @JoinColumn(name = "study_program_ID"),
        inverseJoinColumns = @JoinColumn(name = "course_ID"))
    private Set<Course> courses;
}
