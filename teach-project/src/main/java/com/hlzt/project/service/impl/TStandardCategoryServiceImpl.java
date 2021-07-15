package com.hlzt.project.service.impl;

import java.util.List;

import com.hlzt.common.utils.DateUtils;
import com.hlzt.common.utils.SecurityUtils;
import com.hlzt.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hlzt.project.mapper.TStandardCategoryMapper;
import com.hlzt.project.domain.TStandardCategory;
import com.hlzt.project.service.ITStandardCategoryService;
import com.hlzt.common.annotation.DataDictClass;

/**
 * 验收标准Service业务层处理
 *
 * @author dengyy
 * @date 2021-07-05
 */
@Service
public class TStandardCategoryServiceImpl implements ITStandardCategoryService {
    @Autowired
    private TStandardCategoryMapper tStandardCategoryMapper;

    /**
     * 查询验收标准
     *
     * @param standardId 验收标准ID
     * @return 验收标准
     */
    @DataDictClass
    @Override
    public TStandardCategory selectTStandardCategoryById(Long standardId) {
        return tStandardCategoryMapper.selectTStandardCategoryById(standardId);
    }

    /**
     * 查询验收标准列表
     *
     * @param tStandardCategory 验收标准
     * @return 验收标准
     */
    @DataDictClass
    @Override
    public List<TStandardCategory> selectTStandardCategoryList(TStandardCategory tStandardCategory) {
        return tStandardCategoryMapper.selectTStandardCategoryList(tStandardCategory);
    }

    /**
     * 新增验收标准
     *
     * @param tStandardCategory 验收标准
     * @return 结果
     */
    @Override
    public int insertTStandardCategory(TStandardCategory tStandardCategory) {
        tStandardCategory.setStandardId(IdUtils.getNextId());
        tStandardCategory.setCreateBy(SecurityUtils.getUsername());
        tStandardCategory.setCreateTime(DateUtils.getNowDate());
        return tStandardCategoryMapper.insertTStandardCategory(tStandardCategory);
    }

    /**
     * 修改验收标准
     *
     * @param tStandardCategory 验收标准
     * @return 结果
     */
    @Override
    public int updateTStandardCategory(TStandardCategory tStandardCategory) {
        tStandardCategory.setUpdateBy(SecurityUtils.getUsername());
        tStandardCategory.setUpdateTime(DateUtils.getNowDate());
        return tStandardCategoryMapper.updateTStandardCategory(tStandardCategory);
    }

    /**
     * 批量删除验收标准
     *
     * @param standardIds 需要删除的验收标准ID
     * @return 结果
     */
    @Override
    public int deleteTStandardCategoryByIds(Long[] standardIds) {
        return tStandardCategoryMapper.deleteTStandardCategoryByIds(standardIds);
    }

    /**
     * 删除验收标准信息
     *
     * @param standardId 验收标准ID
     * @return 结果
     */
    @Override
    public int deleteTStandardCategoryById(Long standardId) {
        return tStandardCategoryMapper.deleteTStandardCategoryById(standardId);
    }
}
