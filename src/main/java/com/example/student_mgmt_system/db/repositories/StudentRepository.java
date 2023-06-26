package com.example.student_mgmt_system.db.repositories;

import com.example.student_mgmt_system.db.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Procedure(name = "student_insert")
    void student_insert(
            @Param("s_embg") String s_embg,
            @Param("s_name") String s_name,
            @Param("s_surname") String s_surname,
            @Param("s_date_of_birth") Date s_date_of_birth,
            @Param("s_email") String s_email,
            @Param("street_name") String street_name,
            @Param("street_num") int street_num,
            @Param("munic") String munic,
            @Param("city_name") String city_name,
            @Param("zip") int zip,
            @Param("country_name") String cuntry_name,
            @Param("s_study_program_name") String s_study_program_name,
            @Param("s_scholarship") int s_scholarship,
            @Param("s_group_name") String s_group_name);
}
