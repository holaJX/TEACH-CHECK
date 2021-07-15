package com.hlzt.web.api.system;

import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.system.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息
 *
 * @author ruo-yi
 */
@Api(value = "用户信息controller", tags = {"用户信息"})
@RestController
@RequestMapping("/api/system/user")
public class SysUserApiController extends BaseController {
    @Autowired
    private ISysUserService userService;

    /**
     * 通过部门Id获取满足权限的用户，建设单位只要单位管理员
     *
     * @param deptId 部门ID
     * @return
     */
    @ApiOperation("通过部门Id获取满足权限的用户")
    @GetMapping("/listUserByDeptAdmin")
    public AjaxResult listUserByDeptAdmin(Long deptId) {
        return userService.listUserByPost(deptId);
    }
}
