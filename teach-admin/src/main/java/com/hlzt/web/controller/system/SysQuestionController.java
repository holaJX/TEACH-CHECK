package com.hlzt.web.controller.system;

import com.hlzt.common.annotation.Log;
import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.core.page.TableDataInfo;
import com.hlzt.common.enums.BusinessType;
import com.hlzt.common.utils.poi.ExcelUtil;
import com.hlzt.system.domain.SysQuestion;
import com.hlzt.system.service.ISysQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 问题反馈Controller
 *
 * @author slx
 * @date 2021-06-01
 */
@RestController
@RequestMapping("/system/question")
public class SysQuestionController extends BaseController {
    @Autowired
    private ISysQuestionService sysQuestionService;

    /**
     * 查询问题反馈列表
     */
    @PreAuthorize("@ss.hasPermi('system:question:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysQuestion sysQuestion) {
        startPage();
        List<SysQuestion> list = sysQuestionService.selectSysQuestionList(sysQuestion);
        return getDataTable(list);
    }

    /**
     * 导出问题反馈列表
     */
    @PreAuthorize("@ss.hasPermi('system:question:export')")
    @Log(title = "问题反馈", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysQuestion sysQuestion) {
        List<SysQuestion> list = sysQuestionService.selectSysQuestionList(sysQuestion);
        ExcelUtil<SysQuestion> util = new ExcelUtil<SysQuestion>(SysQuestion.class);
        return util.exportExcel(list, "问题反馈数据");
    }

    /**
     * 获取问题反馈详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:question:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(sysQuestionService.selectSysQuestionById(id));
    }

    /**
     * 新增问题反馈
     */
    @Log(title = "问题反馈", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysQuestion sysQuestion) {
        return toAjax(sysQuestionService.insertSysQuestion(sysQuestion));
    }

    /**
     * 修改问题反馈
     */
    @PreAuthorize("@ss.hasPermi('system:question:edit')")
    @Log(title = "问题反馈", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysQuestion sysQuestion) {
        return toAjax(sysQuestionService.updateSysQuestion(sysQuestion));
    }

    /**
     * 删除问题反馈
     */
    @PreAuthorize("@ss.hasPermi('system:question:remove')")
    @Log(title = "问题反馈", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(sysQuestionService.deleteSysQuestionByIds(ids));
    }
}
