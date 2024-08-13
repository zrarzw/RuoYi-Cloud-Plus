package org.dromara.bz.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.dromara.bz.domain.bo.BzProjectBo;
import org.dromara.bz.domain.vo.BzProjectVo;
import org.dromara.bz.domain.BzProject;
import org.dromara.bz.mapper.BzProjectMapper;
import org.dromara.bz.service.IBzProjectService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 项目基本信息Service业务层处理
 *
 * @author LionLi
 * @date 2024-08-07
 */
@RequiredArgsConstructor
@Service
public class BzProjectServiceImpl implements IBzProjectService {

    private final BzProjectMapper baseMapper;

    /**
     * 查询项目基本信息
     *
     * @param pjBaseId 主键
     * @return 项目基本信息
     */
    @Override
    public BzProjectVo queryById(Long pjBaseId){
        return baseMapper.selectVoById(pjBaseId);
    }

    /**
     * 分页查询项目基本信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 项目基本信息分页列表
     */
    @Override
    public TableDataInfo<BzProjectVo> queryPageList(BzProjectBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BzProject> lqw = buildQueryWrapper(bo);
        Page<BzProjectVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的项目基本信息列表
     *
     * @param bo 查询条件
     * @return 项目基本信息列表
     */
    @Override
    public List<BzProjectVo> queryList(BzProjectBo bo) {
        LambdaQueryWrapper<BzProject> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BzProject> buildQueryWrapper(BzProjectBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BzProject> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getPjBaseId() != null, BzProject::getPjBaseId, bo.getPjBaseId());
        lqw.like(StringUtils.isNotBlank(bo.getPjName()), BzProject::getPjName, bo.getPjName());
        lqw.eq(StringUtils.isNotBlank(bo.getPjStatus()), BzProject::getPjStatus, bo.getPjStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getPjLeader()), BzProject::getPjLeader, bo.getPjLeader());
        lqw.eq(bo.getUpdateDept() != null, BzProject::getUpdateDept, bo.getUpdateDept());
        return lqw;
    }

    /**
     * 新增项目基本信息
     *
     * @param bo 项目基本信息
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(BzProjectBo bo) {
        BzProject add = MapstructUtils.convert(bo, BzProject.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setPjBaseId(add.getPjBaseId());
        }
        return flag;
    }

    /**
     * 修改项目基本信息
     *
     * @param bo 项目基本信息
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(BzProjectBo bo) {
        BzProject update = MapstructUtils.convert(bo, BzProject.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BzProject entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除项目基本信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteByIds(ids) > 0;
    }
}
