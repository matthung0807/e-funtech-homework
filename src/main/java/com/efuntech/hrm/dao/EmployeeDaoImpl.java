package com.efuntech.hrm.dao;

import com.efuntech.hrm.entity.Base;
import com.efuntech.hrm.entity.Employee;
import com.efuntech.hrm.repo.EmployeeRepo;
import com.efuntech.hrm.service.bo.EmployeeBo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeDaoImpl implements EmployeeDao {

    private final EmployeeRepo employeeRepo;

    @PostConstruct
    public void init(){

        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        String creator = "SYSTEM";

        List<Employee> employeeList = Arrays.asList(
                Employee.builder().name("John")
                        .departmentId(1L)
                        .gender("M")
                        .phone("0911000000")
                        .address("Taipei")
                        .age(30)
                        .createdAt(createTime)
                        .createdBy(creator)
                        .build(),
                Employee.builder().name("Mary")
                        .departmentId(1L)
                        .gender("F")
                        .phone("0911000001")
                        .address("New Taipei City")
                        .age(28)
                        .createdAt(createTime)
                        .createdBy(creator)
                        .build(),
                Employee.builder().name("David")
                        .departmentId(2L)
                        .gender("M")
                        .phone("0912000000")
                        .address("Taipei")
                        .age(30)
                        .createdAt(createTime)
                        .createdBy(creator)
                        .build());

        employeeRepo.saveAll(employeeList);
    }

    @Override
    public Page<Employee> find(EmployeeBo employeeBo, int page) {
        Employee employee = Employee.valueOf(employeeBo);
        return employeeRepo.findAll(
                Example.of(employee),
                PageRequest.of(page, 10));

    }

    @Override
    public Optional<Long> add(EmployeeBo employeeBo) {
        Employee employee = Employee.valueOf(employeeBo);
        employee.setCreatedBy("USER");

        employee = employeeRepo.save(employee);
        return Optional.of(employee)
                .map(Base::getId);

    }

    @Override
    public Optional<Long> update(EmployeeBo employeeBo) {
        return employeeRepo.findById(employeeBo.getId())
                .map(e -> {
                    e.setName(employeeBo.getName());
                    e.setDepartmentId(employeeBo.getDepartmentBo().getId());
                    e.setGender(employeeBo.getGender());
                    e.setPhone(employeeBo.getPhone());
                    e.setAddress(employeeBo.getAddress());
                    e.setAge(employeeBo.getAge());
                    e.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
                    e.setUpdatedBy("USER");
                    return e;
                }).map(employeeRepo::save).map(Employee::getId);
    }

    @Override
    public boolean delete(Long id) {
        employeeRepo.deleteById(id);
        return true;
    }
}
