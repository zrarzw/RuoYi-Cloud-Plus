package org.dromara.bz.domain.bo;

import org.dromara.bz.domain.BzProject;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 项目基本信息业务对象 bz_project
 *
 * @author LionLi
 * @date 2024-08-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = BzProject.class, reverseConvertGenerate = false)
public class BzProjectBo extends BaseEntity {

    /**
     * 项目信息主键
     */

    private Long pjBaseId;

    /**
     * 项目名称
     */
    @NotBlank(message = "项目名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String pjName;

    /**
     * 项目状态
     */
    @NotBlank(message = "项目状态不能为空", groups = { AddGroup.class, EditGroup.class })
    private String pjStatus;

    /**
     * 项目负责人
     */
    @NotBlank(message = "项目负责人不能为空", groups = { AddGroup.class, EditGroup.class })
    private String pjLeader;

    /**
     * 修改部门
     */
    @NotNull(message = "修改部门不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long updateDept;


}
