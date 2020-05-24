package com.efuntech.hrm.service.bo;

import com.efuntech.hrm.controller.dto.req.EmployeeReqDto;
import com.efuntech.hrm.entity.Department;
import com.efuntech.hrm.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@SuperBuilder
public class EmployeeBo extends BaseBo {

    private String name;
    private DepartmentBo departmentBo;
    private String gender;
    private String phone;
    private String address;
    private Integer age;

    public static EmployeeBo valueOf(Employee employee, Department department) {
        EmployeeBo employeeBo = EmployeeBo.builder()
                .id(employee.getId())
                .name(employee.getName())
                .departmentBo(DepartmentBo.valueOf(department))
                .gender(employee.getGender())
                .phone(employee.getPhone())
                .address(employee.getAddress())
                .age(employee.getAge())
                .build();

        employeeBo.setModifier(employee);

        return employeeBo;

    }

    public static EmployeeBo valueOf(EmployeeReqDto employeeReqDto) {

        return EmployeeBo.builder()
                .name(employeeReqDto.getName())
                .departmentBo(DepartmentBo.builder()
                        .id(employeeReqDto.getDepartmentId())
                        .name(employeeReqDto.getDepartmentName())
                        .build()
                )
                .gender(employeeReqDto.getGender())
                .phone(employeeReqDto.getPhone())
                .address(employeeReqDto.getAddress())
                .age(employeeReqDto.getAge()).build();
    }

}
