package com.efuntech.hrm.dao;

import com.efuntech.hrm.entity.Department;
import com.efuntech.hrm.service.bo.DepartmentBo;

import java.util.Optional;

public interface DepartmentDao {

    Optional<Department> findById(Long id);

    Optional<Department> findByName(String name);

    Optional<Long> add(DepartmentBo departmentBo);

    Optional<Long> update(DepartmentBo departmentBo);

    boolean delete(Long id);
}
