package com.efuntech.hrm.service.bo;

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

    private Long departmentId;
    private String gender;
    private String phone;
    private String address;
    private Integer age;

    public static EmployeeBo valueOf(Employee employee) {
        EmployeeBo employeeBo = EmployeeBo.builder()
                .departmentId(employee.getDepartmentId())
                .gender(employee.getGender())
                .phone(employee.getPhone())
                .age(employee.getAge())
                .build();

        employeeBo.setModifier(employee);

        return employeeBo;

    }

}
