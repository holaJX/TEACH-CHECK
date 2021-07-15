package com.hlzt.project.service.impl;

import cn.hutool.core.util.IdUtil;
import com.hlzt.common.annotation.DataDictClass;
import com.hlzt.common.core.domain.entity.SysDept;
import com.hlzt.common.utils.DateUtils;
import com.hlzt.common.utils.SecurityUtils;
import com.hlzt.common.utils.StringUtils;
import com.hlzt.common.utils.TreeUtil;
import com.hlzt.common.utils.uuid.IdUtils;
import com.hlzt.project.domain.TCompanyCategory;
import com.hlzt.project.domain.TPlaceCategory;
import com.hlzt.project.mapper.TCompanyCategoryMapper;
import com.hlzt.project.service.ITCompanyCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 单位类型Service业务层处理
 *
 * @author slx
 * @date 2021-07-02
 */
@Service
public class TCompanyCategoryServiceImpl implements ITCompanyCategoryService {
    @Autowired
    private TCompanyCategoryMapper tCompanyCategoryMapper;

    /**
     * 查询单位类型
     *
     * @param companyId 单位类型ID
     * @return 单位类型
     */
    @DataDictClass
    @Override
    public TCompanyCategory selectTCompanyCategoryById(Long companyId) {
        return tCompanyCategoryMapper.selectTCompanyCategoryById(companyId);
    }

    @Override
    public TCompanyCategory selectTCompanyCategoryByKeyName(String keyName) {
        return tCompanyCategoryMapper.selectTCompanyCategoryByKeyName(keyName);
    }

    /**
     * 查询单位类型列表
     *
     * @param tCompanyCategory 单位类型
     * @return 单位类型
     */
    @DataDictClass
    @Override
    public List<TCompanyCategory> selectTCompanyCategoryList(TCompanyCategory tCompanyCategory) {
        return tCompanyCategoryMapper.selectTCompanyCategoryList(tCompanyCategory);
    }

    @Override
    public List<TCompanyCategory> selectTCompanyCategoryTree(TCompanyCategory tCompanyCategory) {
        List<TCompanyCategory> companyCategories = tCompanyCategoryMapper.selectTCompanyCategoryList(tCompanyCategory);
        return TreeUtil.createTree(companyCategories,"companyId");
    }

    /**
     * 新增单位类型
     *
     * @param tCompanyCategory 单位类型
     * @return 结果
     */
    @Override
    public int insertTCompanyCategory(TCompanyCategory tCompanyCategory) {
        tCompanyCategory.setCompanyId(IdUtils.getNextId());
        tCompanyCategory.setCreateBy(SecurityUtils.getUsername());
        tCompanyCategory.setCreateTime(DateUtils.getNowDate());
        TCompanyCategory info = tCompanyCategoryMapper.selectTCompanyCategoryById(tCompanyCategory.getParentId());
        if (info != null) {
            tCompanyCategory.setAncestors(info.getAncestors() + "," + tCompanyCategory.getParentId());
        } else {
            tCompanyCategory.setAncestors(tCompanyCategory.getParentId().toString());
        }
        return tCompanyCategoryMapper.insertTCompanyCategory(tCompanyCategory);
    }

    /**
     * 修改单位类型
     *
     * @param tCompanyCategory 单位类型
     * @return 结果
     */
    @Override
    public int updateTCompanyCategory(TCompanyCategory tCompanyCategory) {
        tCompanyCategory.setUpdateBy(SecurityUtils.getUsername());
        tCompanyCategory.setUpdateTime(DateUtils.getNowDate());
        TCompanyCategory newParent = tCompanyCategoryMapper.selectTCompanyCategoryById(tCompanyCategory.getParentId());
        TCompanyCategory old = tCompanyCategoryMapper.selectTCompanyCategoryById(tCompanyCategory.getCompanyId());
        if (StringUtils.isNotNull(newParent) && StringUtils.isNotNull(old)) {
            String newAncestors = newParent.getAncestors() + "," + newParent.getCompanyId();
            String oldAncestors = old.getAncestors();
            tCompanyCategory.setAncestors(newAncestors);
            updateTCompanyCategoryChildren(tCompanyCategory.getCompanyId(), newAncestors, oldAncestors);
        }

        return tCompanyCategoryMapper.updateTCompanyCategory(tCompanyCategory);
    }

    /**
     * 修改子元素关系
     * @param companyId
     * @param newAncestors
     * @param oldAncestors
     */
    public void updateTCompanyCategoryChildren(Long companyId, String newAncestors, String oldAncestors) {
        List<TCompanyCategory> children = tCompanyCategoryMapper.selectChildrenTCompanyCategoryById(companyId);
        for (TCompanyCategory child : children) {
            child.setAncestors(child.getAncestors().replaceFirst(oldAncestors, newAncestors));
        }
        if (children.size() > 0) {
            tCompanyCategoryMapper.updateTCompanyCategoryChildren(children);
        }
    }

    /**
     * 批量删除单位类型
     *
     * @param companyIds 需要删除的单位类型ID
     * @return 结果
     */
    @Override
    public int deleteTCompanyCategoryByIds(Long[] companyIds) {
        return tCompanyCategoryMapper.deleteTCompanyCategoryByIds(companyIds);
    }

    /**
     * 删除单位类型信息
     *
     * @param companyId 单位类型ID
     * @return 结果
     */
    @Override
    public int deleteTCompanyCategoryById(Long companyId) {
        return tCompanyCategoryMapper.deleteTCompanyCategoryById(companyId);
    }
}
