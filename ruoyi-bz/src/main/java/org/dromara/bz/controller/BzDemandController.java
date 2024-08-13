package org.dromara.bz.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.web.core.BaseController;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.bz.domain.vo.BzDemandVo;
import org.dromara.bz.domain.bo.BzDemandBo;
import org.dromara.bz.service.IBzDemandService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 需求信息
 * 前端访问路由地址为:/bz/demand
 *
 * @author LionLi
 * @date 2024-08-12
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/demand")
public class BzDemandController extends BaseController {

    private final IBzDemandService bzDemandService;

    /**
     * 查询需求信息列表
     */
    @SaCheckPermission("bz:demand:list")
    @GetMapping("/list")
    public TableDataInfo<BzDemandVo> list(BzDemandBo bo, PageQuery pageQuery) {
        return bzDemandService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出需求信息列表
     */
    @SaCheckPermission("bz:demand:export")
    @Log(title = "需求信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BzDemandBo bo, HttpServletResponse response) {
        List<BzDemandVo> list = bzDemandService.queryList(bo);
        ExcelUtil.exportExcel(list, "需求信息", BzDemandVo.class, response);
    }

    /**
     * 获取需求信息详细信息
     *
     * @param demandId 主键
     */
    @SaCheckPermission("bz:demand:query")
    @GetMapping("/{demandId}")
    public R<BzDemandVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long demandId) {
        return R.ok(bzDemandService.queryById(demandId));
    }

    /**
     * 新增需求信息
     */
    @SaCheckPermission("bz:demand:add")
    @Log(title = "需求信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BzDemandBo bo) {
        return toAjax(bzDemandService.insertByBo(bo));
    }

    /**
     * 修改需求信息
     */
    @SaCheckPermission("bz:demand:edit")
    @Log(title = "需求信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BzDemandBo bo) {
        return toAjax(bzDemandService.updateByBo(bo));
    }

    /**
     * 删除需求信息
     *
     * @param demandIds 主键串
     */
    @SaCheckPermission("bz:demand:remove")
    @Log(title = "需求信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{demandIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] demandIds) {
        return toAjax(bzDemandService.deleteWithValidByIds(List.of(demandIds), true));
    }
}
