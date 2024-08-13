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
import org.dromara.bz.domain.vo.BzProjectVo;
import org.dromara.bz.domain.bo.BzProjectBo;
import org.dromara.bz.service.IBzProjectService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 项目基本信息
 * 前端访问路由地址为:/bz/project
 *
 * @author LionLi
 * @date 2024-08-07
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/project")
public class BzProjectController extends BaseController {

    private final IBzProjectService bzProjectService;

    /**
     * 查询项目基本信息列表
     */
    @SaCheckPermission("bz:project:list")
    @GetMapping("/list")
    public TableDataInfo<BzProjectVo> list(BzProjectBo bo, PageQuery pageQuery) {
        return bzProjectService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出项目基本信息列表
     */
    @SaCheckPermission("bz:project:export")
    @Log(title = "项目基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BzProjectBo bo, HttpServletResponse response) {
        List<BzProjectVo> list = bzProjectService.queryList(bo);
        ExcelUtil.exportExcel(list, "项目基本信息", BzProjectVo.class, response);
    }

    /**
     * 获取项目基本信息详细信息
     *
     * @param pjBaseId 主键
     */
    @SaCheckPermission("bz:project:query")
    @GetMapping("/{pjBaseId}")
    public R<BzProjectVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long pjBaseId) {
        return R.ok(bzProjectService.queryById(pjBaseId));
    }

    /**
     * 新增项目基本信息
     */
    @SaCheckPermission("bz:project:add")
    @Log(title = "项目基本信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BzProjectBo bo) {
        return toAjax(bzProjectService.insertByBo(bo));
    }

    /**
     * 修改项目基本信息
     */
    @SaCheckPermission("bz:project:edit")
    @Log(title = "项目基本信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BzProjectBo bo) {
        return toAjax(bzProjectService.updateByBo(bo));
    }

    /**
     * 删除项目基本信息
     *
     * @param pjBaseIds 主键串
     */
    @SaCheckPermission("bz:project:remove")
    @Log(title = "项目基本信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{pjBaseIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] pjBaseIds) {
        return toAjax(bzProjectService.deleteWithValidByIds(List.of(pjBaseIds), true));
    }
}
