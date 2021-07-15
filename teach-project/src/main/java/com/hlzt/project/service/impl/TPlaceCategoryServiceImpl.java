package com.hlzt.project.service.impl;

import com.hlzt.common.annotation.DataDictClass;
import com.hlzt.common.utils.DateUtils;
import com.hlzt.common.utils.SecurityUtils;
import com.hlzt.common.utils.StringUtils;
import com.hlzt.common.utils.TreeUtil;
import com.hlzt.common.utils.uuid.IdUtils;
import com.hlzt.project.domain.TPlaceCategory;
import com.hlzt.project.mapper.TPlaceCategoryMapper;
import com.hlzt.project.service.ITPlaceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部位类别Service业务层处理
 *
 * @author slx
 * @date 2021-07-02
 */
@Service
public class TPlaceCategoryServiceImpl implements ITPlaceCategoryService {
    @Autowired
    private TPlaceCategoryMapper tPlaceCategoryMapper;

    /**
     * 查询部位类别
     *
     * @param placeId 部位类别ID
     * @return 部位类别
     */
    @DataDictClass
    @Override
    public TPlaceCategory selectTPlaceCategoryById(Long placeId) {
        return tPlaceCategoryMapper.selectTPlaceCategoryById(placeId);
    }

    /**
     * 查询部位类别列表
     *
     * @param tPlaceCategory 部位类别
     * @return 部位类别
     */
    @DataDictClass
    @Override
    public List<TPlaceCategory> selectTPlaceCategoryList(TPlaceCategory tPlaceCategory) {
        return tPlaceCategoryMapper.selectTPlaceCategoryList(tPlaceCategory);
    }

    @Override
    public List<TPlaceCategory> selectTPlaceCategoryTree(TPlaceCategory tPlaceCategory) {
        List<TPlaceCategory> placeCategories = tPlaceCategoryMapper.selectTPlaceCategoryList(tPlaceCategory);
        return TreeUtil.createTree(placeCategories, "placeId");
    }

    /**
     * 新增部位类别
     *
     * @param tPlaceCategory 部位类别
     * @return 结果
     */
    @Override
    public int insertTPlaceCategory(TPlaceCategory tPlaceCategory) {
        tPlaceCategory.setPlaceId(IdUtils.getNextId());
        tPlaceCategory.setCreateBy(SecurityUtils.getUsername());
        tPlaceCategory.setCreateTime(DateUtils.getNowDate());
        TPlaceCategory info = tPlaceCategoryMapper.selectTPlaceCategoryById(tPlaceCategory.getParentId());
        if (info != null) {
            tPlaceCategory.setAncestors(info.getAncestors() + "," + tPlaceCategory.getParentId());
        } else {
            tPlaceCategory.setAncestors(tPlaceCategory.getParentId().toString());
        }
        return tPlaceCategoryMapper.insertTPlaceCategory(tPlaceCategory);
    }

    /**
     * 修改部位类别
     *
     * @param tPlaceCategory 部位类别
     * @return 结果
     */
    @Override
    public int updateTPlaceCategory(TPlaceCategory tPlaceCategory) {
        tPlaceCategory.setUpdateBy(SecurityUtils.getUsername());
        tPlaceCategory.setUpdateTime(DateUtils.getNowDate());
        TPlaceCategory newParent = tPlaceCategoryMapper.selectTPlaceCategoryById(tPlaceCategory.getParentId());
        TPlaceCategory old = tPlaceCategoryMapper.selectTPlaceCategoryById(tPlaceCategory.getPlaceId());
        if (StringUtils.isNotNull(newParent) && StringUtils.isNotNull(old)) {
            String newAncestors = newParent.getAncestors() + "," + newParent.getPlaceId();
            String oldAncestors = old.getAncestors();
            tPlaceCategory.setAncestors(newAncestors);
            updateTPlaceCategoryChildren(tPlaceCategory.getPlaceId(), newAncestors, oldAncestors);
        }

        return tPlaceCategoryMapper.updateTPlaceCategory(tPlaceCategory);
    }

    /**
     * 修改子元素关系
     *
     * @param companyId
     * @param newAncestors
     * @param oldAncestors
     */
    public void updateTPlaceCategoryChildren(Long companyId, String newAncestors, String oldAncestors) {
        List<TPlaceCategory> children = tPlaceCategoryMapper.selectChildrenTPlaceCategoryById(companyId);
        for (TPlaceCategory child : children) {
            child.setAncestors(child.getAncestors().replaceFirst(oldAncestors, newAncestors));
        }
        if (children.size() > 0) {
            tPlaceCategoryMapper.updateTPlaceCategoryChildren(children);
        }
    }

    /**
     * 批量删除部位类别
     *
     * @param placeIds 需要删除的部位类别ID
     * @return 结果
     */
    @Override
    public int deleteTPlaceCategoryByIds(Long[] placeIds) {
        return tPlaceCategoryMapper.deleteTPlaceCategoryByIds(placeIds);
    }

    /**
     * 删除部位类别信息
     *
     * @param placeId 部位类别ID
     * @return 结果
     */
    @Override
    public int deleteTPlaceCategoryById(Long placeId) {
        return tPlaceCategoryMapper.deleteTPlaceCategoryById(placeId);
    }
}
