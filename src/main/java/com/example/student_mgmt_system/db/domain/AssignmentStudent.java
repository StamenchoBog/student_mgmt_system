package com.example.student_mgmt_system.db.domain;

import com.example.student_mgmt_system.db.domain.composite_keys.AssignmentStudentKey;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "assignment_student")
public class AssignmentStudent {

    /* Composite key */
    @EmbeddedId
    AssignmentStudentKey id;

    @ManyToOne
    @MapsId("course_id")
    @JoinColumn(name = "course_id")
    Course course;

    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id")
    Student student;
}
