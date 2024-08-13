package org.dromara.bz.domain.bo;

import org.dromara.bz.domain.BzDemand;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 需求信息业务对象 bz_demand
 *
 * @author LionLi
 * @date 2024-08-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = BzDemand.class, reverseConvertGenerate = false)
public class BzDemandBo extends BaseEntity {

    /**
     * 需求ID
     */
    @NotNull(message = "需求ID不能为空", groups = { EditGroup.class })
    private Long demandId;

    /**
     * 模块ID
     */
    @NotNull(message = "模块ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long modelId;

    /**
     * 需求名称
     */
    @NotBlank(message = "需求名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String demandName;

    /**
     * 需求内容
     */
    @NotBlank(message = "需求内容不能为空", groups = { AddGroup.class, EditGroup.class })
    private String demandContent;

    /**
     * 需求文件
     */
    @NotBlank(message = "需求文件不能为空", groups = { AddGroup.class, EditGroup.class })
    private String demandWord;

    /**
     * 需求类型
     */
    @NotBlank(message = "需求类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private String demandType;

    /**
     * 备注
     */
    @NotBlank(message = "备注不能为空", groups = { EditGroup.class })
    private String remark;

    /**
     * 需求状态
     */
    @NotBlank(message = "需求状态不能为空", groups = { AddGroup.class, EditGroup.class })
    private String demandStatus;


}
