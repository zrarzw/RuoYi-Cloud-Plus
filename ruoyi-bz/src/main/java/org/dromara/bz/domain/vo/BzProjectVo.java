package org.dromara.bz.domain.vo;

import org.dromara.bz.domain.BzProject;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 项目基本信息视图对象 bz_project
 *
 * @author LionLi
 * @date 2024-08-07
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BzProject.class)
public class BzProjectVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 项目信息主键
     */
    @ExcelProperty(value = "项目信息主键")
    private Long pjBaseId;

    /**
     * 项目名称
     */
    @ExcelProperty(value = "项目名称")
    private String pjName;

    /**
     * 项目状态
     */
    @ExcelProperty(value = "项目状态")
    private String pjStatus;

    /**
     * 项目负责人
     */
    @ExcelProperty(value = "项目负责人")
    private String pjLeader;

    /**
     * 修改部门
     */
    @ExcelProperty(value = "修改部门")
    private Long updateDept;


}
