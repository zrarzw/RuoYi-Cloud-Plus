package org.dromara.bz.service;

import org.dromara.bz.domain.BzDemand;
import org.dromara.bz.domain.vo.BzDemandVo;
import org.dromara.bz.domain.bo.BzDemandBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 需求信息Service接口
 *
 * @author LionLi
 * @date 2024-08-12
 */
public interface IBzDemandService {

    /**
     * 查询需求信息
     *
     * @param demandId 主键
     * @return 需求信息
     */
    BzDemandVo queryById(Long demandId);

    /**
     * 分页查询需求信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 需求信息分页列表
     */
    TableDataInfo<BzDemandVo> queryPageList(BzDemandBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的需求信息列表
     *
     * @param bo 查询条件
     * @return 需求信息列表
     */
    List<BzDemandVo> queryList(BzDemandBo bo);

    /**
     * 新增需求信息
     *
     * @param bo 需求信息
     * @return 是否新增成功
     */
    Boolean insertByBo(BzDemandBo bo);

    /**
     * 修改需求信息
     *
     * @param bo 需求信息
     * @return 是否修改成功
     */
    Boolean updateByBo(BzDemandBo bo);

    /**
     * 校验并批量删除需求信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
