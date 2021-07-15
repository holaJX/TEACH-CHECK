package com.hlzt.web.api.system;

import com.hlzt.common.annotation.Log;
import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.core.page.TableDataInfo;
import com.hlzt.common.enums.BusinessType;
import com.hlzt.common.enums.NotificationType;
import com.hlzt.common.utils.SecurityUtils;
import com.hlzt.system.domain.SysNotification;
import com.hlzt.system.service.ISysNotificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 消息通知Controller
 *
 * @author dengyy
 * @date 2021-06-02
 */
@Api(value = "消息通知Controller", tags = {"消息通知"})
@RestController
@RequestMapping("/api/system/notification")
public class SysNotificationApiController extends BaseController {
    @Autowired
    private ISysNotificationService sysNotificationService;

    /**
     * 查询消息通知列表
     */
    @ApiOperation("查询公告通知/消息提醒列表")
    @GetMapping("/list")
    public TableDataInfo list(SysNotification sysNotification) {
        startPage();
        if (sysNotification.getNotificationType().equals(NotificationType.TASK_ARRANGEMENT.getValue())) {
            sysNotification.setReceiver(SecurityUtils.getUserId());
        } else if (sysNotification.getNotificationType().equals(NotificationType.NOTICE_ARRANGEMENT.getValue())) {
            sysNotification.setReceiverDept(SecurityUtils.getLoginUser().getUser().getDeptId().toString());
        } else {
            //借用
            sysNotification.setEditStatus("1");
            sysNotification.setReceiver(SecurityUtils.getUserId());
            sysNotification.setReceiverDept(SecurityUtils.getLoginUser().getUser().getDeptId().toString());
        }
        List<SysNotification> list = sysNotificationService.selectSysNotificationList(sysNotification);
        return getDataTable(list);
    }

    /**
     * 查询消息通知列表
     */
    @ApiOperation("查询我的列表")
    @GetMapping("/myList")
    public TableDataInfo myList(SysNotification sysNotification) {
        startPage();
        sysNotification.setCreateBy(SecurityUtils.getUsername());
        List<SysNotification> list = sysNotificationService.selectSysNotificationList(sysNotification);
        return getDataTable(list);
    }

    /**
     * 新增消息通知
     */
    @ApiOperation("新增消息通知")
    @Log(title = "消息通知", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysNotification sysNotification) {
        if (!sysNotification.getNotificationType().equals(NotificationType.NOTICE_ARRANGEMENT.getValue())) {
            return AjaxResult.error("仅允许新增上级通知！");
        }
        return toAjax(sysNotificationService.insertSysNotification(sysNotification));
    }

    /**
     * 获取消息通知详细信息
     */
    @ApiOperation("获取消息通知详细信息")
    @GetMapping(value = "/{notificationId}")
    public AjaxResult getInfo(@PathVariable("notificationId") Long notificationId) {
        return AjaxResult.success(sysNotificationService.selectSysNotificationById(notificationId));
    }

    /**
     * 修改消息通知
     */
    @ApiOperation("修改消息通知")
    @Log(title = "消息通知", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysNotification sysNotification) {
        return toAjax(sysNotificationService.updateSysNotification(sysNotification));
    }

    /**
     * 修改消息通知
     */
    @ApiOperation("接收消息")
    @Log(title = "接收消息", businessType = BusinessType.UPDATE)
    @PutMapping("/receiver/{notificationIds}")
    public AjaxResult receiver(@PathVariable Long[] notificationIds) {
        return toAjax(sysNotificationService.receiver(notificationIds));
    }

    /**
     * 删除消息通知
     */
    @ApiOperation("删除消息通知")
    @Log(title = "消息通知", businessType = BusinessType.DELETE)
    @DeleteMapping("/{notificationIds}")
    public AjaxResult remove(@PathVariable Long[] notificationIds) {
        return toAjax(sysNotificationService.deleteSysNotificationByIds(notificationIds));
    }
}
