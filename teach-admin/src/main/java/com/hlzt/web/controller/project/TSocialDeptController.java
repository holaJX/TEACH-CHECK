package com.hlzt.web.controller.project;

import com.hlzt.common.annotation.DataDictClass;
import com.hlzt.common.annotation.Log;
import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.core.page.TableDataInfo;
import com.hlzt.common.enums.BusinessType;
import com.hlzt.common.utils.StringUtils;
import com.hlzt.common.utils.poi.ExcelUtil;
import com.hlzt.project.domain.TSocialDept;
import com.hlzt.project.service.ITSocialDeptService;
import com.hlzt.system.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 社会单位业务Controller
 *
 * @author slx
 * @date 2021-07-01
 */
@RestController
@RequestMapping("/project/socialdept")
public class TSocialDeptController extends BaseController {
    @Autowired
    private ITSocialDeptService tSocialDeptService;
    @Autowired
    private ISysDeptService deptService;

    /**
     * 查询社会单位业务列表
     */

    @PreAuthorize("@ss.hasPermi('project:socialdept:list')")
    @GetMapping("/list")

    public TableDataInfo list(TSocialDept tSocialDept) {
        startPage();
        List<TSocialDept> list = tSocialDeptService.selectTSocialDeptList(tSocialDept);
        return getDataTable(list);
    }

    /**
     * 导出社会单位业务列表
     */
    @PreAuthorize("@ss.hasPermi('project:socialdept:export')")
    @Log(title = "社会单位业务", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TSocialDept tSocialDept) {
        List<TSocialDept> list = tSocialDeptService.selectTSocialDeptList(tSocialDept);
        ExcelUtil<TSocialDept> util = new ExcelUtil<TSocialDept>(TSocialDept.class);
        return util.exportExcel(list, "社会单位业务数据");
    }

    /**
     * 获取社会单位业务详细信息
     */
    @PreAuthorize("@ss.hasPermi('project:socialdept:query')")
    @GetMapping(value = "/{deptId}")
    public AjaxResult getInfo(@PathVariable("deptId") Long deptId) {
        TSocialDept tSocialDept = tSocialDeptService.selectTSocialDeptById(deptId);
        if (tSocialDept == null) {
            return AjaxResult.success(deptService.selectDeptById(deptId));
        }
        return AjaxResult.success(tSocialDept);
    }

    /**
     * 新增社会单位业务
     */
    @PreAuthorize("@ss.hasPermi('project:socialdept:add')")
    @Log(title = "社会单位业务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TSocialDept tSocialDept) {
        return toAjax(tSocialDeptService.insertTSocialDept(tSocialDept));
    }

    /**
     * 修改社会单位业务
     */
    @PreAuthorize("@ss.hasPermi('project:socialdept:edit')")
    @Log(title = "社会单位业务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TSocialDept tSocialDept) {
        return toAjax(tSocialDeptService.updateTSocialDept(tSocialDept));
    }

    /**
     * 删除社会单位业务
     */
    @PreAuthorize("@ss.hasPermi('project:socialdept:remove')")
    @Log(title = "社会单位业务", businessType = BusinessType.DELETE)
    @DeleteMapping("/{deptIds}")
    public AjaxResult remove(@PathVariable Long[] deptIds) {
        return toAjax(tSocialDeptService.deleteTSocialDeptByIds(deptIds));
    }
}
