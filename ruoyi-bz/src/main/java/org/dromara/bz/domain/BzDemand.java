package org.dromara.bz.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 需求信息对象 bz_demand
 *
 * @author LionLi
 * @date 2024-08-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("bz_demand")
public class BzDemand extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 需求ID
     */
    @TableId(value = "demand_id")
    private Long demandId;

    /**
     * 模块ID
     */
    private Long modelId;

    /**
     * 需求名称
     */
    private String demandName;

    /**
     * 需求内容
     */
    private String demandContent;

    /**
     * 需求文件
     */
    private String demandWord;

    /**
     * 需求类型
     */
    private String demandType;

    /**
     * 备注
     */
    private String remark;

    /**
     * 需求状态
     */
    private String demandStatus;


}
