package com.hlzt.web.api.system;

import com.hlzt.common.annotation.Log;
import com.hlzt.common.core.controller.BaseController;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.core.page.TableDataInfo;
import com.hlzt.common.enums.BusinessType;
import com.hlzt.system.domain.SysNotice;
import com.hlzt.system.service.ISysNoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 公告 信息操作处理
 *
 * @author ruo-yi
 */
@Api(value = "公告controller", tags = {"公告信息操作处理"})
@RestController
@RequestMapping("/api/system/notice")
public class SysNoticeApiController extends BaseController {
    @Autowired
    private ISysNoticeService noticeService;

    /**
     * 获取通知公告列表
     */
    @ApiOperation("获取通知公告列表(type：2政策法规 type：4常见问题)")
    @GetMapping("/list")
    public TableDataInfo list(SysNotice notice) {
        startPage();
        //按照区域、级别来划分
        List<SysNotice> list = noticeService.selectNoticeList(notice);
        return getDataTable(list);
    }

    /**
     * 获取通知公告列表
     */
    @ApiOperation("获取隐私政策")
    @GetMapping("/getNotice")
    public AjaxResult getNotice() {
        SysNotice notice = new SysNotice();
        notice.setNoticeType("3");
        List<SysNotice> list = noticeService.selectNoticeList(notice);
        if (list.size() > 0) {
            return AjaxResult.success(list.get(0));
        }
        return AjaxResult.error();
    }

    /**
     * 新增通知公告
     */
    @ApiOperation("新增通知公告")
    @Log(title = "通知公告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysNotice notice)
    {
        return toAjax(noticeService.insertNotice(notice));
    }

    /**
     * 根据通知公告编号获取详细信息
     */
    @ApiOperation("根据通知公告编号获取详细信息")
    @GetMapping(value = "/{noticeId}")
    public AjaxResult getInfo(@PathVariable Long noticeId) {
        return AjaxResult.success(noticeService.selectNoticeById(noticeId));
    }
}
