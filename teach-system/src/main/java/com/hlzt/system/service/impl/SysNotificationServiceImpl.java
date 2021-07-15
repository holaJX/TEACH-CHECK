package com.hlzt.system.service.impl;

import com.hlzt.common.annotation.DataDictClass;
import com.hlzt.common.core.domain.entity.SysDept;
import com.hlzt.common.enums.PushState;
import com.hlzt.common.enums.ReceiverState;
import com.hlzt.common.utils.DateUtils;
import com.hlzt.common.utils.SecurityUtils;
import com.hlzt.system.domain.SysNotification;
import com.hlzt.system.mapper.SysNotificationMapper;
import com.hlzt.system.service.ISysDeptService;
import com.hlzt.system.service.ISysNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 消息通知Service业务层处理
 *
 * @author dengyy
 * @date 2021-06-02
 */
@Service
public class SysNotificationServiceImpl implements ISysNotificationService {
    @Autowired
    private SysNotificationMapper sysNotificationMapper;
    @Autowired
    private ISysDeptService sysDeptService;

    /**
     * 查询消息通知
     *
     * @param notificationId 消息通知ID
     * @return 消息通知
     */
    @DataDictClass
    @Override
    public SysNotification selectSysNotificationById(Long notificationId) {
        SysNotification sysNotification=sysNotificationMapper.selectSysNotificationById(notificationId);
        if (sysNotification.getCreateBy().equals(SecurityUtils.getUsername())) {
            sysNotification.setEditStatus("1");
        } else {
            sysNotification.setEditStatus("0");
        }
        return sysNotification;
    }

    /**
     * 查询消息通知列表
     *
     * @param sysNotification 消息通知
     * @return 消息通知
     */
    @DataDictClass
    @Override
    public List<SysNotification> selectSysNotificationList(SysNotification sysNotification) {
        List<SysNotification> sysNotifications = sysNotificationMapper.selectSysNotificationList(sysNotification);
        sysNotifications.forEach(sysNotification1 -> {
            if (sysNotification1.getCreateBy().equals(SecurityUtils.getUsername())) {
                sysNotification1.setEditStatus("1");
            } else {
                sysNotification1.setEditStatus("0");
            }
        });
        return sysNotifications;
    }

    /**
     * 新增消息通知
     *
     * @param sysNotification 消息通知
     * @return 结果
     */
    @Override
    public int insertSysNotification(SysNotification sysNotification) {
        //判断，如果有人直接选择人，
        if (sysNotification.getReceiver() == null) {
            //如果没有，则采用权限获取相关部门
            List<SysDept> deptList = sysDeptService.selectDeptList(new SysDept());
            sysNotification.setReceiverDept(deptList.stream().map(r -> r.getDeptId().toString()).collect(Collectors.joining(",")));
        }
        sysNotification.setCreateBy(SecurityUtils.getUsername());
        sysNotification.setCreateTime(DateUtils.getNowDate());
        return sysNotificationMapper.insertSysNotification(sysNotification);
    }

    /**
     * 修改消息通知
     *
     * @param sysNotification 消息通知
     * @return 结果
     */
    @Override
    public int updateSysNotification(SysNotification sysNotification) {
        sysNotification.setUpdateBy(SecurityUtils.getUsername());
        sysNotification.setUpdateTime(DateUtils.getNowDate());
        return sysNotificationMapper.updateSysNotification(sysNotification);
    }

    @Override
    public int receiver(Long[] notificationIds) {
        for (Long notificationId : notificationIds) {
            SysNotification sysNotification = sysNotificationMapper.selectSysNotificationById(notificationId);
            sysNotification.setReceiverState(ReceiverState.RECEIVERED.getValue());
            sysNotification.setUpdateBy(SecurityUtils.getUsername());
            sysNotification.setUpdateTime(DateUtils.getNowDate());
            sysNotificationMapper.updateSysNotification(sysNotification);
        }
        return notificationIds.length;

    }

    /**
     * 批量删除消息通知
     *
     * @param notificationIds 需要删除的消息通知ID
     * @return 结果
     */
    @Override
    public int deleteSysNotificationByIds(Long[] notificationIds) {
        return sysNotificationMapper.deleteSysNotificationByIds(notificationIds);
    }

    /**
     * 删除消息通知信息
     *
     * @param notificationId 消息通知ID
     * @return 结果
     */
    @Override
    public int deleteSysNotificationById(Long notificationId) {
        return sysNotificationMapper.deleteSysNotificationById(notificationId);
    }

    @Override
    public void pushNotification(String notificationIds) {
        String[] list = notificationIds.split(",");
        for (String notificationId : list) {
            Long pk = Long.parseLong(notificationId);
            SysNotification sysNotification = sysNotificationMapper
                    .selectSysNotificationById(pk)
                    .setPusher(SecurityUtils.getUserId())
                    .setPushState(PushState.SUCCESS.getValue());
            sysNotificationMapper.updateSysNotification(sysNotification);
        }
    }
}
