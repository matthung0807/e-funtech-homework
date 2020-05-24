package com.efuntech.hrm.service;

import com.efuntech.hrm.controller.dto.req.EmployeeReqDto;
import com.efuntech.hrm.dao.DepartmentDaoImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentDaoImpl departmentDao;

    @Override
    public Optional<Long> add(EmployeeReqDto employeeReqDto) {
        return Optional.empty();
    }

    @Override
    public Optional<Long> update(EmployeeReqDto employeeReqDto) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
