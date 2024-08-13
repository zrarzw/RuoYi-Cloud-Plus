package org.dromara.bz.service;

import org.dromara.bz.domain.BzProject;
import org.dromara.bz.domain.vo.BzProjectVo;
import org.dromara.bz.domain.bo.BzProjectBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 项目基本信息Service接口
 *
 * @author LionLi
 * @date 2024-08-07
 */
public interface IBzProjectService {

    /**
     * 查询项目基本信息
     *
     * @param pjBaseId 主键
     * @return 项目基本信息
     */
    BzProjectVo queryById(Long pjBaseId);

    /**
     * 分页查询项目基本信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 项目基本信息分页列表
     */
    TableDataInfo<BzProjectVo> queryPageList(BzProjectBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的项目基本信息列表
     *
     * @param bo 查询条件
     * @return 项目基本信息列表
     */
    List<BzProjectVo> queryList(BzProjectBo bo);

    /**
     * 新增项目基本信息
     *
     * @param bo 项目基本信息
     * @return 是否新增成功
     */
    Boolean insertByBo(BzProjectBo bo);

    /**
     * 修改项目基本信息
     *
     * @param bo 项目基本信息
     * @return 是否修改成功
     */
    Boolean updateByBo(BzProjectBo bo);

    /**
     * 校验并批量删除项目基本信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
