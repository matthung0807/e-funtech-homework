package com.efuntech.hrm.service.bo;

import com.efuntech.hrm.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@SuperBuilder
public class DepartmentBo extends BaseBo {

    private String name;

    public static DepartmentBo valueOf(Department department) {
        DepartmentBo departmentBo = DepartmentBo.builder()
                .name(department.getName())
                .build();

        departmentBo.setModifier(department);

        return departmentBo;
    }

}
