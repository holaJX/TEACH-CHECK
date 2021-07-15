package com.hlzt.project.service;

import java.util.List;
import com.hlzt.project.domain.TPlaceCategory;

/**
 * 部位类别Service接口
 * 
 * @author slx
 * @date 2021-07-02
 */
public interface ITPlaceCategoryService {
    /**
     * 查询部位类别
     * 
     * @param placeId 部位类别ID
     * @return 部位类别
     */
    public TPlaceCategory selectTPlaceCategoryById(Long placeId);

    /**
     * 查询部位类别列表
     * 
     * @param tPlaceCategory 部位类别
     * @return 部位类别集合
     */
    public List<TPlaceCategory> selectTPlaceCategoryList(TPlaceCategory tPlaceCategory);

    /**
     * 查询树
     * @param tPlaceCategory
     * @return
     */
    public List<TPlaceCategory> selectTPlaceCategoryTree(TPlaceCategory tPlaceCategory);

    /**
     * 新增部位类别
     * 
     * @param tPlaceCategory 部位类别
     * @return 结果
     */
    public int insertTPlaceCategory(TPlaceCategory tPlaceCategory);

    /**
     * 修改部位类别
     * 
     * @param tPlaceCategory 部位类别
     * @return 结果
     */
    public int updateTPlaceCategory(TPlaceCategory tPlaceCategory);

    /**
     * 批量删除部位类别
     * 
     * @param placeIds 需要删除的部位类别ID
     * @return 结果
     */
    public int deleteTPlaceCategoryByIds(Long[] placeIds);

    /**
     * 删除部位类别信息
     * 
     * @param placeId 部位类别ID
     * @return 结果
     */
    public int deleteTPlaceCategoryById(Long placeId);
}
