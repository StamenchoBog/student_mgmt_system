package com.example.student_mgmt_system.db.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "lecture")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    @Column(length = 100)
    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "type_of_lecture_id")
    private TypeOfLecture typeOfLecture;

    @ManyToOne
    @JoinColumn(name = "laboratory_id")
    private Laboratory laboratory;

    @ManyToOne
    @JoinColumn(name = "educator_id")
    private Educator educator;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
