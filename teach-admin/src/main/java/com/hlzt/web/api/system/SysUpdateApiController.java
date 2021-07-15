package com.hlzt.web.api.system;

import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.system.service.ISysUpdateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 应用更新Controller
 *
 * @author slx
 * @date 2021-06-01
 */
@Api(value="应用更新Controller",tags={"应用更新"})
@RestController
@RequestMapping("/api/system/update")
public class SysUpdateApiController extends BaseController {
    @Autowired
    private ISysUpdateService sysUpdateService;

    /**
     * 获取应用更新详细信息
     */
    @ApiOperation("获取应用最新更新详细信息")
    @GetMapping(value = "/getLast")
    public AjaxResult getLast() {
        return AjaxResult.success(sysUpdateService.getLast());
    }
}
