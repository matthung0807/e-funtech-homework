package com.efuntech.hrm.controller.dto.req;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EmployeeReqDto {

    private Long id;
    private String name;
    private String departmentName;
    private String gender;
    private String phone;
    private String address;
    private Integer age;

    private Integer page;

    @JsonIgnore
    private Long departmentId;

}
