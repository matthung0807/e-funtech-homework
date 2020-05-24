package com.efuntech.hrm.entity;

import com.efuntech.hrm.service.bo.DepartmentBo;
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
public class Department extends Base {

    private String name;

    public static Department valueOf(DepartmentBo departmentBo) {
        return Department.builder()
                .name(departmentBo.getName())
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .build();
    }

    public static Department empty() {
        return new Department();
    }

}
