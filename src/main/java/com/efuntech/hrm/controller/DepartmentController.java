package com.efuntech.hrm.controller;

import com.efuntech.hrm.controller.dto.req.DepartmentReqDto;
import com.efuntech.hrm.controller.dto.res.ResponseDto;
import com.efuntech.hrm.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/add")
    public ResponseDto add(@RequestBody DepartmentReqDto departmentReqDto) {
        return departmentService.add(departmentReqDto)
                .map(ResponseDto::success)
                .orElse(ResponseDto.fail());
    }

    @PutMapping("/update")
    public ResponseDto update(@RequestBody DepartmentReqDto departmentReqDto) {
        return departmentService.update(departmentReqDto)
                .map(ResponseDto::success)
                .orElse(ResponseDto.fail());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        return departmentService.delete(id) ?
                ResponseDto.success() :
                ResponseDto.fail();
    }
}
