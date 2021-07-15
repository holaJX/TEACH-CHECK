package com.hlzt.project.service.impl;

import com.hlzt.common.annotation.DataDictClass;
import com.hlzt.common.core.domain.CommonEntity;
import com.hlzt.common.enums.NotificationType;
import com.hlzt.common.enums.PushState;
import com.hlzt.common.enums.ReceiverState;
import com.hlzt.common.utils.DateUtils;
import com.hlzt.common.utils.SecurityUtils;
import com.hlzt.project.domain.TFireProduct;
import com.hlzt.project.domain.TProjectFireequipment;
import com.hlzt.project.mapper.TProjectFireequipmentMapper;
import com.hlzt.project.service.ITFireProductService;
import com.hlzt.project.service.ITProjectFireequipmentService;
import com.hlzt.system.domain.SysNotification;
import com.hlzt.system.service.ISysNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 工程消防设施Service业务层处理
 *
 * @author slx
 * @date 2021-05-07
 */
@Service
public class TProjectFireequipmentServiceImpl implements ITProjectFireequipmentService {
    @Autowired
    private TProjectFireequipmentMapper tProjectFireequipmentMapper;
    @Autowired
    private ITFireProductService tFireProductService;

    /**
     * 查询工程消防设施
     *
     * @param fireEquipmentId 工程消防设施ID
     * @return 工程消防设施
     */
    @Override
    public TProjectFireequipment selectTProjectFireequipmentById(Long fireEquipmentId) {
        return tProjectFireequipmentMapper.selectTProjectFireequipmentById(fireEquipmentId);
    }

    /**
     * 查询工程消防设施列表
     *
     * @param TProjectFireequipment 工程消防设施
     * @return 工程消防设施
     */
    @DataDictClass
    @Override
    public List<TProjectFireequipment> selectTProjectFireequipmentList(TProjectFireequipment TProjectFireequipment) {
        return tProjectFireequipmentMapper.selectTProjectFireequipmentList(TProjectFireequipment);
    }

    /**
     * 新增工程消防设施
     *
     * @param TProjectFireequipment 工程消防设施
     * @return 结果
     */
    @Override
    public int insertTProjectFireequipment(TProjectFireequipment TProjectFireequipment) {
        TProjectFireequipment TProjectFireequipment1 = new TProjectFireequipment();
        TProjectFireequipment1.setDeptId(TProjectFireequipment.getDeptId());
        TProjectFireequipment.setCreateBy(SecurityUtils.getUsername());
        TProjectFireequipment.setCreateTime(DateUtils.getNowDate());

        if (TProjectFireequipment.getManufacturer() != null
                && TProjectFireequipment.getSpecification() != null
                && TProjectFireequipment.getEquipmentCategoryId() !=null) {

            tFireProductService.saveTFireProduct(new TFireProduct()
                    .setManufacturer(String.valueOf(TProjectFireequipment.getManufacturer()))
                    .setSpecification(String.valueOf(TProjectFireequipment.getSpecification()))
                    .setEquipType(Long.parseLong(TProjectFireequipment.getEquipmentCategoryId()))
            );

        }

        return tProjectFireequipmentMapper.insertTProjectFireequipment(TProjectFireequipment);
    }


    /**
     * 修改工程消防设施
     *
     * @param TProjectFireequipment 工程消防设施
     * @return 结果
     */
    @Override
    public int updateTProjectFireequipment(TProjectFireequipment TProjectFireequipment) {
        TProjectFireequipment.setUpdateBy(SecurityUtils.getUsername());
        TProjectFireequipment.setUpdateTime(DateUtils.getNowDate());

        tFireProductService.saveTFireProduct(
                new TFireProduct()
                        .setManufacturer(TProjectFireequipment.getManufacturer())
                        .setSpecification(TProjectFireequipment.getSpecification())
                        .setEquipType(Long.parseLong(TProjectFireequipment.getEquipmentCategoryId()))
        );
        return tProjectFireequipmentMapper.updateTProjectFireequipment(TProjectFireequipment);
    }

    /**
     * 批量删除工程消防设施
     *
     * @param fireEquipmentIds 需要删除的工程消防设施ID
     * @return 结果
     */
    @Override
    public int deleteTProjectFireequipmentByIds(Long[] fireEquipmentIds) {
        return tProjectFireequipmentMapper.deleteTProjectFireequipmentByIds(fireEquipmentIds);
    }

    /**
     * 删除工程消防设施信息
     *
     * @param fireEquipmentId 工程消防设施ID
     * @return 结果
     */
    @Override
    public int deleteTProjectFireequipmentById(Long fireEquipmentId) {
        return tProjectFireequipmentMapper.deleteTProjectFireequipmentById(fireEquipmentId);
    }

    @Override
    public List<CommonEntity> listPosition(CommonEntity commonEntity) {
        return tProjectFireequipmentMapper.listPosition(commonEntity);
    }
}
