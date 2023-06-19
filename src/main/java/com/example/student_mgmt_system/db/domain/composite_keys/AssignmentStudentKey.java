package com.example.student_mgmt_system.db.domain.composite_keys;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.Data;

@Embeddable
@Data
public class AssignmentStudentKey implements Serializable {

    @Column(name = "assignment_id", nullable = false)
    Long assignment_id;

    @Column(name = "course_id", nullable = false)
    Long course_id;
}
