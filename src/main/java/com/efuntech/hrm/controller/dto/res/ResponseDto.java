package com.efuntech.hrm.controller.dto.res;

import com.efuntech.hrm.controller.dto.PageDto;
import com.efuntech.hrm.service.bo.PageBo;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
@Builder
public class ResponseDto {

    private String message;
    private String code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PageDto page;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    public static ResponseDto success(Object data) {
        Objects.requireNonNull(data);

        return ResponseDto.builder()
                .data(data)
                .code(ResponseMessage.SUCCESS.getCode())
                .message(ResponseMessage.SUCCESS.getMessage())
                .build();
    }

    public static ResponseDto success(PageBo pageBo) {
        Objects.requireNonNull(pageBo);

        return ResponseDto.builder()
                .data(pageBo.getList())
                .page(PageDto.valueOf(pageBo))
                .code(ResponseMessage.SUCCESS.getCode())
                .message(ResponseMessage.SUCCESS.getMessage())
                .build();
    }

    public static ResponseDto success() {
        return ResponseDto.builder()
                .code(ResponseMessage.SUCCESS.getCode())
                .message(ResponseMessage.SUCCESS.getMessage())
                .build();
    }

    public static ResponseDto empty() {
        return success();
    }

    public static ResponseDto fail() {
        return ResponseDto.builder()
                .code(ResponseMessage.FAIL.getCode())
                .message(ResponseMessage.FAIL.getMessage())
                .build();
    }

    public static ResponseDto error() {
        return ResponseDto.builder()
                .code(ResponseMessage.ERROR.getCode())
                .message(ResponseMessage.ERROR.getMessage())
                .build();
    }
}
