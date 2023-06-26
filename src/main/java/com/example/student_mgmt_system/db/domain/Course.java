package com.example.student_mgmt_system.db.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    private Integer credits;

    @NotNull
    private Integer semestar;

    @NotNull
    private Integer level;

    // Relations
    @ManyToMany
    @JoinTable(
        name = "study_program_course",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "study_program_id"))
    private Set<StudyProgram> studyPrograms;

    @ManyToMany
    @JoinTable(
        name = "educator_course",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "educator_person_id"))
    private Set<Educator> educators;

    public String getName() {
        return name;
    }

    public Integer getCredits() {
        return credits;
    }

    public Integer getSemestar() {
        return semestar;
    }

    public Integer getLevel() {
        return level;
    }

    @ManyToMany
    @JoinTable(
        name = "course_course",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "required_course_id"))
    private Set<Course> required_courses;
}
