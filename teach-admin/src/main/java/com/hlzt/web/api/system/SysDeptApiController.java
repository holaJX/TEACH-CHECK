package com.hlzt.web.api.system;

import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.core.domain.SysDeptUserVo;
import com.hlzt.common.core.domain.entity.SysDept;
import com.hlzt.common.enums.DeptType;
import com.hlzt.system.service.ISysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门信息
 *
 * @author ruo-yi
 */
@Api(value = "部门信息controller", tags = {"部门信息"})
@RestController
@RequestMapping("/api/system/dept")
public class SysDeptApiController extends BaseController {
    @Autowired
    private ISysDeptService deptService;

    /**
     * 根据部门编号获取详细信息
     */
    @ApiOperation("根据字典类型查询字典数据信息")
    @GetMapping(value = "/{deptId}")
    public AjaxResult getInfo(@PathVariable Long deptId) {
        return AjaxResult.success(deptService.selectDeptById(deptId));
    }

    /**
     * 获取项目创建部门下拉树列表
     */
    @ApiOperation("获取项目创建部门下拉树列表")
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
     * 查询组织结构下拉树
     *
     * @return
     */
    @ApiOperation("查询组织结构下拉树")
    @GetMapping("/findOrgUserTree")
    @ResponseBody
    public AjaxResult findOrgUserTree() {
        List<SysDeptUserVo> deptList = deptService.selectDeptAndUser(new SysDept());
        List<SysDeptUserVo> treeSelectVos = deptService.buildDeptTreeVoSelect(deptList);
        return AjaxResult.success(treeSelectVos);
    }


    /**
     * 模糊搜索list查询
     *
     * @param deptName
     * @return
     */
    @ApiOperation("模糊搜索list查询")
    @GetMapping("/search")
    public AjaxResult searchList(String deptName) {
        SysDept sysDept = new SysDept();
        sysDept.setDeptId(DeptType.SERVICE.getDeptId());
        sysDept.setDeptName(deptName);
        return AjaxResult.success(deptService.selectDeptLikeName(sysDept));
    }
}
