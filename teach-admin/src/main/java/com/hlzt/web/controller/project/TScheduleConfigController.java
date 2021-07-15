package com.hlzt.web.controller.project;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hlzt.common.annotation.Log;
import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.enums.BusinessType;
import com.hlzt.project.domain.TScheduleConfig;
import com.hlzt.project.service.ITScheduleConfigService;
import com.hlzt.common.utils.poi.ExcelUtil;
import com.hlzt.common.core.page.TableDataInfo;

/**
 * 任务配置Controller
 * 
 * @author dyy
 * @date 2021-07-06
 */
@RestController
@RequestMapping("/project/config")
public class TScheduleConfigController extends BaseController {
    @Autowired
    private ITScheduleConfigService tScheduleConfigService;

    /**
     * 查询任务配置列表
     */
    @PreAuthorize("@ss.hasPermi('project:config:list')")
    @GetMapping("/list")
    public TableDataInfo list(TScheduleConfig tScheduleConfig)
    {
        startPage();
        List<TScheduleConfig> list = tScheduleConfigService.selectTScheduleConfigList(tScheduleConfig);
        return getDataTable(list);
    }

    /**
     * 导出任务配置列表
     */
    @PreAuthorize("@ss.hasPermi('project:config:export')")
    @Log(title = "任务配置", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TScheduleConfig tScheduleConfig)
    {
        List<TScheduleConfig> list = tScheduleConfigService.selectTScheduleConfigList(tScheduleConfig);
        ExcelUtil<TScheduleConfig> util = new ExcelUtil<TScheduleConfig>(TScheduleConfig.class);
        return util.exportExcel(list, "任务配置数据");
    }

    /**
     * 获取任务配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('project:config:query')")
    @GetMapping(value = "/{scheduleId}")
    public AjaxResult getInfo(@PathVariable("scheduleId") Long scheduleId)
    {
        return AjaxResult.success(tScheduleConfigService.selectTScheduleConfigById(scheduleId));
    }

    /**
     * 新增任务配置
     */
    @PreAuthorize("@ss.hasPermi('project:config:add')")
    @Log(title = "任务配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TScheduleConfig tScheduleConfig)
    {
        return toAjax(tScheduleConfigService.insertTScheduleConfig(tScheduleConfig));
    }

    /**
     * 修改任务配置
     */
    @PreAuthorize("@ss.hasPermi('project:config:edit')")
    @Log(title = "任务配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TScheduleConfig tScheduleConfig)
    {
        return toAjax(tScheduleConfigService.updateTScheduleConfig(tScheduleConfig));
    }

    /**
     * 删除任务配置
     */
    @PreAuthorize("@ss.hasPermi('project:config:remove')")
    @Log(title = "任务配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{scheduleIds}")
    public AjaxResult remove(@PathVariable Long[] scheduleIds)
    {
        return toAjax(tScheduleConfigService.deleteTScheduleConfigByIds(scheduleIds));
    }
}
