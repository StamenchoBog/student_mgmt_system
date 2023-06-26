package com.example.student_mgmt_system.db.repositories;

import com.example.student_mgmt_system.db.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface CoursesRepository extends JpaRepository<Course, Long> {
    @Procedure(name = "course_insert")
    void course_insert(@Param("c_name") String c_name,
                       @Param("c_credits") Integer c_credits,
                       @Param("c_semester") Integer c_semester,
                       @Param("c_level") Integer c_level
    );
}
