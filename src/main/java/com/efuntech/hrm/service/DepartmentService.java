package com.efuntech.hrm.service;

import com.efuntech.hrm.controller.dto.req.EmployeeReqDto;

import java.util.Optional;

public interface DepartmentService {

    Optional<Long> add(EmployeeReqDto employeeReqDto);

    Optional<Long> update(EmployeeReqDto employeeReqDto);

    boolean delete(Long id);
}
