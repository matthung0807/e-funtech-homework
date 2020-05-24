package com.efuntech.hrm.service;

import com.efuntech.hrm.controller.dto.req.DepartmentReqDto;
import com.efuntech.hrm.dao.DepartmentDaoImpl;
import com.efuntech.hrm.service.bo.DepartmentBo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentDaoImpl departmentDao;

    @Override
    public Optional<Long> add(DepartmentReqDto departmentReqDto) {
        DepartmentBo departmentBo = DepartmentBo.valueOf(departmentReqDto);
        return departmentDao.add(departmentBo);
    }

    @Override
    public Optional<Long> update(DepartmentReqDto departmentReqDto) {
        DepartmentBo departmentBo = DepartmentBo.valueOf(departmentReqDto);
        return departmentDao.update(departmentBo);
    }

    @Override
    public boolean delete(Long id) {
        return departmentDao.delete(id);
    }
}
