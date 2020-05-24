package com.efuntech.hrm.dao;

import com.efuntech.hrm.repo.DepartmentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentDaoImpl {

    private final DepartmentRepo departmentRepo;

}
