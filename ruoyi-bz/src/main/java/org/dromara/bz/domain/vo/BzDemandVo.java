package org.dromara.bz.domain.vo;

import org.dromara.bz.domain.BzDemand;
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
 * 需求信息视图对象 bz_demand
 *
 * @author LionLi
 * @date 2024-08-12
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BzDemand.class)
public class BzDemandVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 需求ID
     */
    @ExcelProperty(value = "需求ID")
    private Long demandId;

    /**
     * 模块ID
     */
    @ExcelProperty(value = "模块ID")
    private Long modelId;

    /**
     * 需求名称
     */
    @ExcelProperty(value = "需求名称")
    private String demandName;

    /**
     * 需求内容
     */
    @ExcelProperty(value = "需求内容")
    private String demandContent;

    /**
     * 需求文件
     */
    @ExcelProperty(value = "需求文件")
    private String demandWord;

    /**
     * 需求类型
     */
    @ExcelProperty(value = "需求类型")
    private String demandType;

    /**
     * 需求状态
     */
    @ExcelProperty(value = "需求状态")
    private String demandStatus;


}
