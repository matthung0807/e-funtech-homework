package com.efuntech.hrm.dao;

import com.efuntech.hrm.entity.Employee;
import com.efuntech.hrm.repo.EmployeeRepo;
import com.efuntech.hrm.service.bo.EmployeeBo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeDaoImpl implements EmployeeDao {

    private final EmployeeRepo employeeRepo;

    @Override
    public Page<Employee> get(EmployeeBo employeeBo) {
        return null;
    }

    @Override
    public Optional<Long> add(EmployeeBo employeeBo) {
        return Optional.empty();
    }

    @Override
    public Optional<Long> update(EmployeeBo employeeBo) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
