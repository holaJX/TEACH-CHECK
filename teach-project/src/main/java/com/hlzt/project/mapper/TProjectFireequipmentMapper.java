package com.hlzt.project.mapper;

import com.hlzt.common.core.domain.CommonEntity;
import com.hlzt.project.domain.TProjectFireequipment;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 工程消防设施Mapper接口
 *
 * @author slx
 * @date 2021-05-07
 */
public interface TProjectFireequipmentMapper extends Mapper<TProjectFireequipment> {
    /**
     * 查询工程消防设施
     *
     * @param fireEquipmentId 工程消防设施ID
     * @return 工程消防设施
     */
    public TProjectFireequipment selectTProjectFireequipmentById(Long fireEquipmentId);

    /**
     * 查询工程消防设施列表
     *
     * @param TProjectFireequipment 工程消防设施
     * @return 工程消防设施集合
     */
    public List<TProjectFireequipment> selectTProjectFireequipmentList(TProjectFireequipment TProjectFireequipment);


    /**
     * 查询位置
     *
     * @param commonEntity
     * @return
     */
    List<CommonEntity> listPosition(CommonEntity commonEntity);

    /**
     * 新增工程消防设施
     *
     * @param TProjectFireequipment 工程消防设施
     * @return 结果
     */
    public int insertTProjectFireequipment(TProjectFireequipment TProjectFireequipment);

    /**
     * 修改工程消防设施
     *
     * @param TProjectFireequipment 工程消防设施
     * @return 结果
     */
    public int updateTProjectFireequipment(TProjectFireequipment TProjectFireequipment);

    /**
     * 删除工程消防设施
     *
     * @param fireEquipmentId 工程消防设施ID
     * @return 结果
     */
    public int deleteTProjectFireequipmentById(Long fireEquipmentId);

    /**
     * 批量删除工程消防设施
     *
     * @param fireEquipmentIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTProjectFireequipmentByIds(Long[] fireEquipmentIds);
}
