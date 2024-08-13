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
import org.dromara.bz.domain.bo.BzDemandBo;
import org.dromara.bz.domain.vo.BzDemandVo;
import org.dromara.bz.domain.BzDemand;
import org.dromara.bz.mapper.BzDemandMapper;
import org.dromara.bz.service.IBzDemandService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 需求信息Service业务层处理
 *
 * @author LionLi
 * @date 2024-08-12
 */
@RequiredArgsConstructor
@Service
public class BzDemandServiceImpl implements IBzDemandService {

    private final BzDemandMapper baseMapper;

    /**
     * 查询需求信息
     *
     * @param demandId 主键
     * @return 需求信息
     */
    @Override
    public BzDemandVo queryById(Long demandId){
        return baseMapper.selectVoById(demandId);
    }

    /**
     * 分页查询需求信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 需求信息分页列表
     */
    @Override
    public TableDataInfo<BzDemandVo> queryPageList(BzDemandBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BzDemand> lqw = buildQueryWrapper(bo);
        Page<BzDemandVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的需求信息列表
     *
     * @param bo 查询条件
     * @return 需求信息列表
     */
    @Override
    public List<BzDemandVo> queryList(BzDemandBo bo) {
        LambdaQueryWrapper<BzDemand> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BzDemand> buildQueryWrapper(BzDemandBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BzDemand> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getModelId() != null, BzDemand::getModelId, bo.getModelId());
        lqw.like(StringUtils.isNotBlank(bo.getDemandName()), BzDemand::getDemandName, bo.getDemandName());
        lqw.like(StringUtils.isNotBlank(bo.getDemandContent()), BzDemand::getDemandContent, bo.getDemandContent());
        lqw.like(StringUtils.isNotBlank(bo.getDemandWord()), BzDemand::getDemandWord, bo.getDemandWord());
        lqw.eq(StringUtils.isNotBlank(bo.getDemandType()), BzDemand::getDemandType, bo.getDemandType());
        lqw.eq(StringUtils.isNotBlank(bo.getDemandStatus()), BzDemand::getDemandStatus, bo.getDemandStatus());
        return lqw;
    }

    /**
     * 新增需求信息
     *
     * @param bo 需求信息
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(BzDemandBo bo) {
        BzDemand add = MapstructUtils.convert(bo, BzDemand.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setDemandId(add.getDemandId());
        }
        return flag;
    }

    /**
     * 修改需求信息
     *
     * @param bo 需求信息
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(BzDemandBo bo) {
        BzDemand update = MapstructUtils.convert(bo, BzDemand.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BzDemand entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除需求信息信息
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
