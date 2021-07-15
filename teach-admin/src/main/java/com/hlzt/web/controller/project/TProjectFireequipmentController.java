package com.hlzt.web.controller.project;

import com.hlzt.common.annotation.DataDictClass;
import com.hlzt.common.annotation.Log;
import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.core.domain.CommonEntity;
import com.hlzt.common.core.page.TableDataInfo;
import com.hlzt.common.enums.BusinessType;
import com.hlzt.common.utils.poi.ExcelUtil;
import com.hlzt.common.utils.uuid.IdUtils;
import com.hlzt.project.domain.TProjectFireequipment;
import com.hlzt.project.service.ITProjectFireequipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 工程消防设施Controller
 *
 * @author slx
 * @date 2021-05-07
 */
@RestController
@RequestMapping("/project/fireequipment")
public class TProjectFireequipmentController extends BaseController {
    @Autowired
    private ITProjectFireequipmentService TProjectFireequipmentService;

    /**
     * 查询工程消防设施列表
     */
    @GetMapping("/list")
    public TableDataInfo list(TProjectFireequipment TProjectFireequipment)
    {
        startPage();
        List<TProjectFireequipment> list = TProjectFireequipmentService.selectTProjectFireequipmentList(TProjectFireequipment);
        return getDataTable(list);
    }

    /**
     * 导出工程消防设施列表
     */
    @Log(title = "工程消防设施", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TProjectFireequipment TProjectFireequipment)
    {
        List<TProjectFireequipment> list = TProjectFireequipmentService.selectTProjectFireequipmentList(TProjectFireequipment);
        ExcelUtil<TProjectFireequipment> util = new ExcelUtil<TProjectFireequipment>(TProjectFireequipment.class);
        return util.exportExcel(list, "工程消防设施数据");
    }

    /**
     * 获取工程消防设施详细信息
     */
    @DataDictClass(ObjClass = TProjectFireequipment.class)
    @GetMapping(value = "/{fireEquipmentId}")
    public AjaxResult getInfo(@PathVariable("fireEquipmentId") Long fireEquipmentId)
    {
        return AjaxResult.success(TProjectFireequipmentService.selectTProjectFireequipmentById(fireEquipmentId));
    }
    /**
     * 获取设置位置
     */
    @GetMapping(value = "/listPosition")
    public AjaxResult listPosition(CommonEntity commonEntity)
    {
        List<CommonEntity> list = TProjectFireequipmentService.listPosition(commonEntity);
        return AjaxResult.success(list);
    }

    /**
     * 新增工程消防设施
     */
    @PreAuthorize("@ss.hasPermi('project:fireequipment:add')")
    @Log(title = "工程消防设施", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TProjectFireequipment TProjectFireequipment)
    {
        TProjectFireequipment.setFireEquipmentId(IdUtils.getNextId());
        return toAjax(TProjectFireequipmentService.insertTProjectFireequipment(TProjectFireequipment));
    }

    /**
     * 修改工程消防设施
     */
    @PreAuthorize("@ss.hasPermi('project:fireequipment:edit')")
    @Log(title = "工程消防设施", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TProjectFireequipment TProjectFireequipment)
    {
        return toAjax(TProjectFireequipmentService.updateTProjectFireequipment(TProjectFireequipment));
    }

    /**
     * 删除工程消防设施
     */
    @PreAuthorize("@ss.hasPermi('project:fireequipment:remove')")
    @Log(title = "工程消防设施", businessType = BusinessType.DELETE)
    @DeleteMapping("/{fireEquipmentIds}")
    public AjaxResult remove(@PathVariable Long[] fireEquipmentIds)
    {
        return toAjax(TProjectFireequipmentService.deleteTProjectFireequipmentByIds(fireEquipmentIds));
    }
}
