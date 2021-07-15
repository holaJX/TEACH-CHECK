package com.hlzt.web.api.system;

import com.hlzt.common.annotation.Log;
import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.enums.BusinessType;
import com.hlzt.system.domain.SysQuestion;
import com.hlzt.system.service.ISysQuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 问题反馈Controller
 *
 * @author slx
 * @date 2021-06-01
 */
@Api(value = " 问题反馈Controller", tags = {"问题反馈"})
@RestController
@RequestMapping("/api/system/question")
public class SysQuestionApiController extends BaseController {
    @Autowired
    private ISysQuestionService sysQuestionService;

    /**
     * 获取问题反馈详细信息
     */
    @ApiOperation("获取问题反馈详细信息")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(sysQuestionService.selectSysQuestionById(id));
    }

    /**
     * 新增问题反馈
     */
    @ApiOperation("新增问题反馈")
    @Log(title = "问题反馈", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysQuestion sysQuestion) {
        return toAjax(sysQuestionService.insertSysQuestion(sysQuestion));
    }
}
