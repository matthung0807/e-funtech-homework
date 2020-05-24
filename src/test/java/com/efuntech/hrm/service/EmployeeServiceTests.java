package com.efuntech.hrm.service;

import com.efuntech.hrm.controller.dto.req.EmployeeReqDto;
import com.efuntech.hrm.dao.EmployeeDao;
import com.efuntech.hrm.service.bo.EmployeeBo;
import com.efuntech.hrm.service.bo.PageBo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;

@SpringBootTest
public class EmployeeServiceTests {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeDao employeeDao;

    @Test
    public void testGetEmpty() {

        EmployeeBo employeeBo = EmployeeBo.builder().age(0).build();
        Mockito.when(employeeDao.get(employeeBo)).thenReturn(Page.empty());

        EmployeeReqDto employeeReqDto = EmployeeReqDto.builder().age(0).build();
        PageBo actual = employeeService.get(employeeReqDto);

        PageBo expected = PageBo.empty();
        Assertions.assertEquals(expected, actual);

    }
}
