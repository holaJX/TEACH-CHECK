package com.hlzt.project.mapper;

import com.hlzt.project.domain.TEquipmentCategory;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 建筑消防设施Mapper接口
 * 
 * @author slx
 * @date 2021-04-27
 */
public interface TEquipmentCategoryMapper extends Mapper<TEquipmentCategory>{
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
     * 删除建筑消防设施
     * 
     * @param equipmentId 建筑消防设施ID
     * @return 结果
     */
    public int deleteTEquipmentCategoryById(Long equipmentId);

    /**
     * 批量删除建筑消防设施
     * 
     * @param equipmentIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTEquipmentCategoryByIds(Long[] equipmentIds);
}
