package com.efuntech.hrm.service;

import com.efuntech.hrm.controller.dto.req.DepartmentReqDto;

import java.util.Optional;

public interface DepartmentService {

    Optional<Long> add(DepartmentReqDto departmentReqDto);

    Optional<Long> update(DepartmentReqDto departmentReqDto);

    boolean delete(Long id);
}
