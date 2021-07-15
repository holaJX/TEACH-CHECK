package com.hlzt.web.controller.system;

import com.hlzt.common.annotation.Log;
import com.hlzt.common.constant.UserConstants;
import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.core.domain.SysDeptUserVo;
import com.hlzt.common.core.domain.entity.SysDept;
import com.hlzt.common.core.page.TableDataInfo;
import com.hlzt.common.enums.BusinessType;
import com.hlzt.common.enums.DeptType;
import com.hlzt.common.utils.SecurityUtils;
import com.hlzt.common.utils.StringUtils;
import com.hlzt.system.service.ISysDeptService;
import com.hlzt.system.service.ISysUserService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 部门信息
 *
 * @author ruo-yi
 */
@RestController
@RequestMapping("/system/dept")
public class SysDeptController extends BaseController {
    @Autowired
    private ISysDeptService deptService;

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 获取部门列表
     */
    @GetMapping("/list")
    public AjaxResult list(SysDept dept) {
        List<SysDept> depts = deptService.selectDeptList(dept);
        return AjaxResult.success(depts);
    }

    @GetMapping("/deptList")
    public TableDataInfo deptList(SysDept dept) {
        startPage();
        List<SysDept> depts = deptService.selectDeptList(dept);
        return getDataTable(depts);
    }
    @GetMapping("/socialDeptList")
    public TableDataInfo socialList(SysDept dept) {
        startPage();
        List<SysDept> depts = deptService.selectDeptListByConditon(dept);
        return getDataTable(depts);
    }

    /**
     * 模糊搜索list查询
     *
     * @param deptName
     * @return
     */
    @GetMapping("/search")
    public AjaxResult searchList(String deptName) {
        SysDept sysDept = new SysDept();
        sysDept.setDeptId(DeptType.CONSTRUCTION.getDeptId());
        sysDept.setDeptName(deptName);
        return AjaxResult.success(deptService.selectDeptLikeName(sysDept));
    }

    /**
     * 查询部门列表（排除节点）
     */
    @PreAuthorize("@ss.hasPermi('system:dept:list')")
    @GetMapping("/list/exclude/{deptId}")
    public AjaxResult excludeChild(@PathVariable(value = "deptId", required = false) Long deptId) {
        List<SysDept> depts = deptService.selectDeptList(new SysDept());
        Iterator<SysDept> it = depts.iterator();
        while (it.hasNext()) {
            SysDept d = (SysDept) it.next();
            if (d.getDeptId().intValue() == deptId
                    || ArrayUtils.contains(StringUtils.split(d.getAncestors(), ","), deptId + "")) {
                it.remove();
            }
        }
        return AjaxResult.success(depts);
    }

    /**
     * 根据部门编号获取详细信息
     */
    @GetMapping(value = "/{deptId}")
    public AjaxResult getInfo(@PathVariable Long deptId) {
        return AjaxResult.success(deptService.selectDeptById(deptId));
    }

    /**
     * 根据部门编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:dept:edit')")
    @PutMapping(value = "/changeStatus")
    public AjaxResult changeStatus(@RequestBody SysDept dept) {
        dept.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(deptService.updateDeptStatus(dept));
    }

    /**
     * 获取部门下拉树列表
     */
    @GetMapping("/treeselect")
    public AjaxResult treeselect(SysDept dept) {
        List<SysDept> depts = deptService.selectDeptList(dept);
        return AjaxResult.success(deptService.buildDeptTreeSelect(depts));
    }

    /**
     * 获取部门下拉树列表
     */
    @GetMapping("/allDeptByParentId")
    public AjaxResult getAllDeptListByParentId(Long parentId) {
        List<SysDept> depts = deptService.selectDeptListByParentId(parentId, null, null);
        return AjaxResult.success(deptService.buildDeptTreeSelect(depts));
    }

    /**
     * 获取t特殊部门下拉树列表
     */
    @GetMapping("/getTreeItems")
    public AjaxResult getTreeItems(Long parentId, String code) {
        List<SysDept> depts = new ArrayList<>();
        if (parentId == null || parentId == (DeptType.CONSTRUCTION.getDeptId().longValue())) {
            depts = deptService.selectDeptList(new SysDept());
        } else if (parentId == (DeptType.SUPERVISION.getDeptId().longValue())) {
            depts = deptService.getSupervisionItems(parentId, code);
        }
        return AjaxResult.success(deptService.buildDeptTreeSelect(depts));
    }

    /**
     * 加载对应角色部门列表树
     */
    @GetMapping(value = "/roleDeptTreeselect/{roleId}")
    public AjaxResult roleDeptTreeselect(@PathVariable("roleId") Long roleId) {
        List<SysDept> depts = deptService.selectDeptList(new SysDept());
        AjaxResult ajax = AjaxResult.success();
        ajax.put("checkedKeys", deptService.selectDeptListByRoleId(roleId));
        ajax.put("depts", deptService.buildDeptTreeSelect(depts));
        return ajax;
    }

    /**
     * 新增部门
     */
    @PreAuthorize("@ss.hasPermi('system:dept:add')")
    @Log(title = "部门管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysDept dept) {
        if (UserConstants.NOT_UNIQUE.equals(deptService.checkDeptNameUnique(dept))) {
            return AjaxResult.error("新增部门'" + dept.getDeptName() + "'失败，单位名称已存在");
        }
        dept.setCreateBy(SecurityUtils.getUsername());
        return toAjax(deptService.insertDept(dept));
    }

    /**
     * 修改部门
     */
    @PreAuthorize("@ss.hasPermi('system:dept:edit')")
    @Log(title = "部门管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysDept dept) {
        if (UserConstants.NOT_UNIQUE.equals(deptService.checkDeptNameUnique(dept))) {
            return AjaxResult.error("修改部门'" + dept.getDeptName() + "'失败，单位名称已存在");
        } else if (dept.getParentId().equals(dept.getDeptId())) {
            return AjaxResult.error("修改部门'" + dept.getDeptName() + "'失败，上级机构不能是自己");
        } else if (StringUtils.equals(UserConstants.DEPT_DISABLE, dept.getStatus())
                && deptService.selectNormalChildrenDeptById(dept.getDeptId()) > 0) {
            return AjaxResult.error("该部门包含未停用的子部门！");
        }
        dept.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(deptService.updateDept(dept));
    }

    /**
     * 删除部门
     */
    @PreAuthorize("@ss.hasPermi('system:dept:remove')")
    @Log(title = "部门管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{deptId}")
    public AjaxResult remove(@PathVariable Long deptId) {
        if (deptService.hasChildByDeptId(deptId)) {
            return AjaxResult.error("存在下级部门,不允许删除");
        }
        if (deptService.checkDeptExistUser(deptId)) {
            return AjaxResult.error("部门存在用户,不允许删除");
        }
        return toAjax(deptService.deleteDeptById(deptId));
    }

    /**
     * 查询组织结构下拉树
     *
     * @return
     */
    @RequestMapping(value = "/findOrgUserTree", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public AjaxResult findOrgUserTree() {
        List<SysDeptUserVo> deptList = deptService.selectDeptAndUser(new SysDept());
        return AjaxResult.success(deptService.buildDeptTreeVoSelect(deptList));
    }

}
