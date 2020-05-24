package com.efuntech.hrm.controller;

import com.efuntech.hrm.controller.dto.req.EmployeeReqDto;
import com.efuntech.hrm.controller.dto.res.ResponseDto;
import com.efuntech.hrm.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/test")
    public ResponseDto test() {
        return ResponseDto.success();
    }

    @GetMapping("/get")
    public ResponseDto get(@RequestBody EmployeeReqDto employeeReqDto) {

        return null;
    }


    @PostMapping("/add")
    public ResponseDto add(@RequestBody EmployeeReqDto employeeReqDto) {

        return null;
    }

    @PutMapping("/update")
    public ResponseDto update(@RequestBody EmployeeReqDto employeeReqDto) {

        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {

        return null;
    }

}
