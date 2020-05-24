package com.efuntech.hrm.entity;

import com.efuntech.hrm.service.bo.EmployeeBo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Employee extends Base {

    private String name;
    private Long departmentId;
    private String gender;
    private String phone;
    private String address;
    private Integer age;

    public static Employee valueOf(EmployeeBo employeeBo) {
        return Employee.builder()
                .name(employeeBo.getName())
                .departmentId(employeeBo.getDepartmentBo().getId())
                .gender(employeeBo.getGender())
                .phone(employeeBo.getPhone())
                .address(employeeBo.getAddress())
                .age(employeeBo.getAge())
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .build();

    }

}
