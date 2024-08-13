package org.dromara.bz.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 项目基本信息对象 bz_project
 *
 * @author LionLi
 * @date 2024-08-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("bz_project")
public class BzProject extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 项目信息主键
     */
    @TableId(value = "pj_base_id")
    private Long pjBaseId;

    /**
     * 项目名称
     */
    private String pjName;

    /**
     * 项目状态
     */
    private String pjStatus;

    /**
     * 项目负责人
     */
    private String pjLeader;

    /**
     * 删除标志
     */
    @TableLogic
    private String delFlag;

    /**
     * 修改部门
     */
    private Long updateDept;


    /**
     * 租户
     */
    private String tenantId;




}
