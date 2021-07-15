package com.hlzt.project.mapper;

import com.hlzt.project.domain.TEquipmentStandard;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 设施标准关联Mapper接口
 * 
 * @author slx
 * @date 2021-05-14
 */
public interface TEquipmentStandardMapper extends Mapper<TEquipmentStandard>{
    /**
     * 查询设施标准关联
     * 
     * @param equipmentId 设施标准关联ID
     * @return 设施标准关联
     */
    public TEquipmentStandard selectTEquipmentStandardById(@Param("equipmentId") Long equipmentId, @Param("standardId") Long standardId);

    /**
     * 查询设施标准关联列表
     * 
     * @param TEquipmentStandard 设施标准关联
     * @return 设施标准关联集合
     */
    public List<TEquipmentStandard> selectTEquipmentStandardList(TEquipmentStandard TEquipmentStandard);

    /**
     * 新增设施标准关联
     * 
     * @param TEquipmentStandard 设施标准关联
     * @return 结果
     */
    public int insertTEquipmentStandard(TEquipmentStandard TEquipmentStandard);

    /**
     * 批量新增信息
     * @param equipmentStandardList
     * @return
     */
    public int batchTEquipmentStandard(List<TEquipmentStandard> equipmentStandardList);

    /**
     * 修改设施标准关联
     * 
     * @param TEquipmentStandard 设施标准关联
     * @return 结果
     */
    public int updateTEquipmentStandard(TEquipmentStandard TEquipmentStandard);

    /**
     * 删除设施标准关联
     * 
     * @param equipmentId 设施标准关联ID
     * @return 结果
     */
    public int deleteTEquipmentStandardByEquipmentId(Long equipmentId);

    /**
     *删除设施标准关联
     *
     * @param standardId
     * @return
     */
    public int deleteTEquipmentStandardByStandardId(Long standardId);

    /**
     * 批量删除设施标准关联
     * 
     * @param equipmentIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTEquipmentStandardByEquipmentIds(Long[] equipmentIds);

    /**
     * 批量删除设施标准关联
     * @param standardIds
     * @return
     */
    public int deleteTEquipmentStandardByStandardIds(Long[] standardIds);
}
