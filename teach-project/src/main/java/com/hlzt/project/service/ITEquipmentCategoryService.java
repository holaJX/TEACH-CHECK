package com.hlzt.project.service;

import com.hlzt.project.domain.TEquipmentCategory;

import java.util.List;

/**
 * 建筑消防设施Service接口
 * 
 * @author slx
 * @date 2021-04-27
 */
public interface ITEquipmentCategoryService {
    /**
     * 查询建筑消防设施
     * 
     * @param equipmentId 建筑消防设施ID
     * @return 建筑消防设施
     */
    public TEquipmentCategory selectTEquipmentCategoryById(Long equipmentId);

    /**
     * 查询建筑消防设施列表
     * 
     * @param TEquipmentCategory 建筑消防设施
     * @return 建筑消防设施集合
     */
    public List<TEquipmentCategory> selectTEquipmentCategoryList(TEquipmentCategory TEquipmentCategory);
    /**
     * 构建前端所需要下拉树结构
     *
     * @param TEquipmentCategorys 列表
     * @return 下拉树结构列表
     */
    public List<TEquipmentCategory> buildTEquipmentCategoryTreeSelect(List<TEquipmentCategory> TEquipmentCategorys);

    /**
     * 新增建筑消防设施
     * 
     * @param TEquipmentCategory 建筑消防设施
     * @return 结果
     */
    public int insertTEquipmentCategory(TEquipmentCategory TEquipmentCategory);

    /**
     * 修改建筑消防设施
     * 
     * @param TEquipmentCategory 建筑消防设施
     * @return 结果
     */
    public int updateTEquipmentCategory(TEquipmentCategory TEquipmentCategory);

    /**
     * 批量删除建筑消防设施
     * 
     * @param equipmentIds 需要删除的建筑消防设施ID
     * @return 结果
     */
    public int deleteTEquipmentCategoryByIds(Long[] equipmentIds);

    /**
     * 删除建筑消防设施信息
     * 
     * @param equipmentId 建筑消防设施ID
     * @return 结果
     */
    public int deleteTEquipmentCategoryById(Long equipmentId);

    List<TEquipmentCategory> selectList(TEquipmentCategory TEquipmentCategory);
}
