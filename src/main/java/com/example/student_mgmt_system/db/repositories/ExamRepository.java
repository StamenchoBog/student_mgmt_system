package com.example.student_mgmt_system.db.repositories;

import com.example.student_mgmt_system.db.domain.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
}
