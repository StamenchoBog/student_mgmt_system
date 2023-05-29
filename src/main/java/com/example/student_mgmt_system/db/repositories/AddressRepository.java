package com.example.student_mgmt_system.db.repositories;

import com.example.student_mgmt_system.db.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
