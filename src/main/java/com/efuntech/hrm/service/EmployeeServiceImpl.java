package com.efuntech.hrm.service;

import com.efuntech.hrm.controller.dto.req.EmployeeReqDto;
import com.efuntech.hrm.dao.EmployeeDao;
import com.efuntech.hrm.service.bo.PageBo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Override
    public PageBo get(EmployeeReqDto employeeReqDto) {

        return null;
    }

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
