package com.hlzt.system.mapper;

import java.util.List;
import tk.mybatis.mapper.common.Mapper;
import com.hlzt.system.domain.SysNotification;

/**
 * 消息通知Mapper接口
 * 
 * @author dengyy
 * @date 2021-06-02
 */
public interface SysNotificationMapper extends Mapper<SysNotification>{
    /**
     * 查询消息通知
     * 
     * @param notificationId 消息通知ID
     * @return 消息通知
     */
    public SysNotification selectSysNotificationById(Long notificationId);

    /**
     * 查询消息通知列表
     * 
     * @param sysNotification 消息通知
     * @return 消息通知集合
     */
    public List<SysNotification> selectSysNotificationList(SysNotification sysNotification);

    /**
     * 新增消息通知
     * 
     * @param sysNotification 消息通知
     * @return 结果
     */
    public int insertSysNotification(SysNotification sysNotification);

    /**
     * 修改消息通知
     * 
     * @param sysNotification 消息通知
     * @return 结果
     */
    public int updateSysNotification(SysNotification sysNotification);

    /**
     * 删除消息通知
     * 
     * @param notificationId 消息通知ID
     * @return 结果
     */
    public int deleteSysNotificationById(Long notificationId);

    /**
     * 批量删除消息通知
     * 
     * @param notificationIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysNotificationByIds(Long[] notificationIds);
}
