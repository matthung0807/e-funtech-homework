package com.efuntech.hrm.service;

import com.efuntech.hrm.controller.dto.req.EmployeeReqDto;
import com.efuntech.hrm.service.bo.PageBo;

import java.util.Optional;

public interface EmployeeService {

    PageBo get(EmployeeReqDto employeeReqDto);

    Optional<Long> add(EmployeeReqDto employeeReqDto);

    Optional<Long> update(EmployeeReqDto employeeReqDto);

    boolean delete(Long id);
}
