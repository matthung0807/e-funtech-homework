package com.efuntech.hrm.service;

import com.efuntech.hrm.controller.dto.req.EmployeeReqDto;
import com.efuntech.hrm.dao.EmployeeDao;
import com.efuntech.hrm.entity.Employee;
import com.efuntech.hrm.service.bo.DepartmentBo;
import com.efuntech.hrm.service.bo.EmployeeBo;
import com.efuntech.hrm.service.bo.PageBo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class EmployeeServiceTests {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeDao employeeDao;

    @Test
    public void testGetEmpty() {

        EmployeeBo employeeBo = EmployeeBo.builder()
                .departmentBo(DepartmentBo.builder().build())
                .age(0).build();

        Mockito.when(employeeDao.find(employeeBo, 0)).thenReturn(Page.empty());

        EmployeeReqDto employeeReqDto = EmployeeReqDto.builder().age(0).page(0).build();
        PageBo actual = employeeService.get(employeeReqDto);

        PageBo expected = PageBo.empty();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testGetByAge() {

        EmployeeBo employeeBo = EmployeeBo.builder()
                .departmentBo(DepartmentBo.builder().build())
                .age(30).build();

        List<Employee> employeeList = Arrays.asList(
                Employee.builder().departmentId(1L).gender("M").phone("0911000001").address("Taipei").age(30).build(),
                Employee.builder().departmentId(2L).gender("F").phone("0911000002").address("New Taipei City").age(30).build());
        Page<Employee> page = new PageImpl<>(employeeList);
        Mockito.when(employeeDao.find(employeeBo, 0)).thenReturn(page);

        EmployeeReqDto employeeReqDto = EmployeeReqDto.builder().age(30).page(0).build();
        int actual = employeeService.get(employeeReqDto).getList().size();
        int expected = 2;
        Assertions.assertEquals(expected, actual);

    }

}
