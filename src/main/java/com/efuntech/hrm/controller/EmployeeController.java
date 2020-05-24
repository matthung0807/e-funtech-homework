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
        return ResponseDto.success(employeeService.get(employeeReqDto));
    }

    @PostMapping("/add")
    public ResponseDto add(@RequestBody EmployeeReqDto employeeReqDto) {
        return employeeService.add(employeeReqDto)
                .map(ResponseDto::success)
                .orElse(ResponseDto.fail());
    }

    @PutMapping("/update")
    public ResponseDto update(@RequestBody EmployeeReqDto employeeReqDto) {
        return employeeService.update(employeeReqDto)
                .map(ResponseDto::success)
                .orElse(ResponseDto.fail());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        return employeeService.delete(id) ?
                ResponseDto.success() :
                ResponseDto.fail();
    }

}
