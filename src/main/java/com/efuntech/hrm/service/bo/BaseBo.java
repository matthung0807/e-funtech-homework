package com.efuntech.hrm.service.bo;

import com.efuntech.hrm.entity.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BaseBo {

    private Long id;
    private String createdBy;
    private Timestamp createdAt;
    private String updatedBy;
    private Timestamp updatedAt;

    public void setModifier(Base base) {
        this.id = base.getId();
        this.createdBy = base.getCreatedBy();
        this.createdAt = base.getCreatedAt();
        this.updatedBy = base.getUpdatedBy();
        this.updatedAt = base.getUpdatedAt();
    }

}
