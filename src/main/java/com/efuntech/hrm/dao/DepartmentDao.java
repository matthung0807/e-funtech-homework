package com.efuntech.hrm.dao;

import com.efuntech.hrm.service.bo.DepartmentBo;

import java.util.Optional;

public interface DepartmentDao {

    Optional<Long> add(DepartmentBo departmentBo);

    Optional<Long> update(DepartmentBo departmentBo);

    boolean delete(Long id);
}
