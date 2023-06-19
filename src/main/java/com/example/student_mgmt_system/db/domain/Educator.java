package com.example.student_mgmt_system.db.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name = "educator")
public class Educator {

    @Id
    @OneToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @NotNull
    @Column(length = 50)
    private String degree;

    @NotNull
    private Integer experience;

    @NotNull
    @OneToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToMany
    @JoinTable(
        name = "educator_course",
        joinColumns = @JoinColumn(name = "educator_person_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> taught_courses;

}
