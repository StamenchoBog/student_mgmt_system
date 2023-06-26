package com.example.student_mgmt_system.db.repositories;

import com.example.student_mgmt_system.db.domain.Student;
import com.example.student_mgmt_system.db.domain.StudentInfoView;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface StudentInfoViewRepository extends ReadOnlyRepository<StudentInfoView, Long> {
    List<StudentInfoView> findByMajor(String major);
}
