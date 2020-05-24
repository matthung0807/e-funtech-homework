package com.efuntech.hrm.repo;

import com.efuntech.hrm.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

    Optional<Department> findByName(String name);
}
