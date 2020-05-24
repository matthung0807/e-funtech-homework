package com.efuntech.hrm.service;

import com.efuntech.hrm.controller.dto.req.EmployeeReqDto;
import com.efuntech.hrm.dao.DepartmentDao;
import com.efuntech.hrm.dao.EmployeeDao;
import com.efuntech.hrm.entity.Department;
import com.efuntech.hrm.entity.Employee;
import com.efuntech.hrm.service.bo.EmployeeBo;
import com.efuntech.hrm.service.bo.PageBo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;
    private final DepartmentDao departmentDao;

    @Override
    public PageBo get(EmployeeReqDto employeeReqDto) {
        setDepartment(employeeReqDto);

        EmployeeBo employeeBo = EmployeeBo.valueOf(employeeReqDto);
        Page<Employee> page = employeeDao.find(
                employeeBo, employeeReqDto.getPage());

        if (page == null) {
            return PageBo.empty();
        }

        List<Employee> employeeList = page.getContent();

        List<EmployeeBo> employeeBoList = employeeList.stream()
                .map(employee -> {
                    Department department = departmentDao
                            .findById(employee.getDepartmentId())
                            .orElse(Department.empty());
                    return EmployeeBo.valueOf(employee, department);
        }).collect(Collectors.toList());

        return PageBo.valueOf(page, employeeBoList);
    }

    private void setDepartment(EmployeeReqDto employeeReqDto) {
        Optional<Department> departmentOpt = departmentDao.findByName(employeeReqDto.getDepartmentName());
        departmentOpt.ifPresent(e -> {
            employeeReqDto.setDepartmentId(e.getId());
            employeeReqDto.setDepartmentName(e.getName());
        });
    }

    @Override
    public Optional<Long> add(EmployeeReqDto employeeReqDto) {
        EmployeeBo employeeBo = EmployeeBo.valueOf(employeeReqDto);
        return employeeDao.add(employeeBo);
    }

    @Override
    public Optional<Long> update(EmployeeReqDto employeeReqDto) {
        EmployeeBo employeeBo = EmployeeBo.valueOf(employeeReqDto);
        return employeeDao.update(employeeBo);
    }

    @Override
    public boolean delete(Long id) {
        return employeeDao.delete(id);
    }

}
