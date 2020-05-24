package com.efuntech.hrm.controller.dto;

import com.efuntech.hrm.service.bo.PageBo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PageDto {

    private Integer currentPage;
    private Integer totalPages;
    private Long totalRecords;
    private Integer pageSize;

    public static PageDto valueOf(PageBo pageBo) {
        if (pageBo == null || pageBo.getList() == null || pageBo.getList().size() == 0) {
            return empty();
        }

        return PageDto.builder()
                .currentPage(pageBo.getCurrentPage())
                .totalPages(pageBo.getTotalPages())
                .totalRecords(pageBo.getTotalRecords())
                .pageSize(pageBo.getPageSize())
                .build();
    }

    public static PageDto empty() {
        return PageDto.builder()
                .currentPage(0)
                .totalPages(0)
                .totalRecords(0L)
                .pageSize(10)
                .build();
    }

}
