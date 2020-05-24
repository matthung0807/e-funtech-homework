package com.efuntech.hrm.service.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PageBo {



    private Integer currentPage;
    private Integer totalPages;
    private Long totalRecords;
    private Integer pageSize = 10;
    private List<? extends BaseBo> list;

    public static PageBo valueOf(Page<?> page) {
        if (page == null || !page.hasContent()) {
            return empty();
        }

        return PageBo.builder()
                .currentPage(page.getNumber())
                .totalPages(page.getTotalPages())
                .totalRecords(page.getTotalElements())
                .pageSize(page.getSize())
                .build();
    }

    public static PageBo empty() {
        return PageBo.builder().build();
    }

}