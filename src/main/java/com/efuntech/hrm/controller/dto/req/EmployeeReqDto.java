package com.efuntech.hrm.controller.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EmployeeReqDto {

    private Long id;
    private Long departmentId;
    private String gender;
    private String phone;
    private String address;
    private Integer age;

}
