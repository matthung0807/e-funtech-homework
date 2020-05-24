package com.efuntech.hrm.dao;

import com.efuntech.hrm.entity.Employee;
import com.efuntech.hrm.service.bo.EmployeeBo;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface EmployeeDao {

    Page<Employee> find(EmployeeBo employeeBo, int page);

    Optional<Long> add(EmployeeBo employeeBo);

    Optional<Long> update(EmployeeBo employeeBo);

    boolean delete(Long id);
}
