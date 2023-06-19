package com.example.student_mgmt_system.db.repositories;

import com.example.student_mgmt_system.db.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
