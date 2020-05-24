package com.efuntech.hrm.controller.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class DepartmentReqDto {

    private Long id;
    private String name;

}
