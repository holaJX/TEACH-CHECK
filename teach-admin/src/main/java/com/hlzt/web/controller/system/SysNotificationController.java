package com.hlzt.web.controller.system;

import com.hlzt.common.annotation.Log;
import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.core.page.TableDataInfo;
import com.hlzt.common.enums.BusinessType;
import com.hlzt.common.enums.NotificationType;
import com.hlzt.common.utils.SecurityUtils;
import com.hlzt.common.utils.StringUtils;
import com.hlzt.common.utils.poi.ExcelUtil;
import com.hlzt.system.domain.SysNotification;
import com.hlzt.system.service.ISysNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 消息通知Controller
 * 
 * @author dengyy
 * @date 2021-06-02
 */
@RestController
@RequestMapping("/system/notification")
public class SysNotificationController extends BaseController {
    @Autowired
    private ISysNotificationService sysNotificationService;

    /**
     * 查询消息通知列表
     */
    @PreAuthorize("@ss.hasPermi('system:notification:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysNotification sysNotification)
    {
        startPage();
        if (StringUtils.isNotBlank(sysNotification.getNotificationType())){
            if (sysNotification.getNotificationType().equals(NotificationType.TASK_ARRANGEMENT.getValue())) {
                sysNotification.setReceiver(SecurityUtils.getUserId());
            } else if (sysNotification.getNotificationType().equals(NotificationType.NOTICE_ARRANGEMENT.getValue())) {
                sysNotification.setReceiverDept(SecurityUtils.getLoginUser().getUser().getDeptId().toString());
            }
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
     * 导出消息通知列表
     */
    @PreAuthorize("@ss.hasPermi('system:notification:export')")
    @Log(title = "消息通知", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysNotification sysNotification)
    {
        List<SysNotification> list = sysNotificationService.selectSysNotificationList(sysNotification);
        ExcelUtil<SysNotification> util = new ExcelUtil<SysNotification>(SysNotification.class);
        return util.exportExcel(list, "消息通知数据");
    }

    /**
     * 获取消息通知详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:notification:query')")
    @GetMapping(value = "/{notificationId}")
    public AjaxResult getInfo(@PathVariable("notificationId") Long notificationId)
    {
        return AjaxResult.success(sysNotificationService.selectSysNotificationById(notificationId));
    }

    /**
     * 新增消息通知
     */
    @PreAuthorize("@ss.hasPermi('system:notification:add')")
    @Log(title = "消息通知", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysNotification sysNotification)
    {
        return toAjax(sysNotificationService.insertSysNotification(sysNotification));
    }

    /**
     * 修改消息通知
     */
    @PreAuthorize("@ss.hasPermi('system:notification:edit')")
    @Log(title = "消息通知", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysNotification sysNotification)
    {
        return toAjax(sysNotificationService.updateSysNotification(sysNotification));
    }

    /**
     * 删除消息通知
     */
    @PreAuthorize("@ss.hasPermi('system:notification:remove')")
    @Log(title = "消息通知", businessType = BusinessType.DELETE)
	@DeleteMapping("/{notificationIds}")
    public AjaxResult remove(@PathVariable Long[] notificationIds)
    {
        return toAjax(sysNotificationService.deleteSysNotificationByIds(notificationIds));
    }
    /**
     * 删除消息通知
     */
    @PreAuthorize("@ss.hasPermi('system:notification:edit')")
    @Log(title = "消息通知", businessType = BusinessType.UPDATE)
	@GetMapping("/pushNotification/{notificationIds}")
    public AjaxResult pushNotification(@PathVariable String notificationIds)
    {
        sysNotificationService.pushNotification(notificationIds);
        return AjaxResult.success();
    }
}
