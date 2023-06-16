package com.example.student_mgmt_system.db.repositories;

import com.example.student_mgmt_system.db.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
