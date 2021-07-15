package com.hlzt.project.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.hlzt.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.*;

/**
 * 验收标准类型对象 acc_standard_category
 *
 * @author slx
 * @date 2021-04-27
 */
@Data
@ApiModel("验收标准类型")
public class TStandardCategoryRecordVo {

    /**
     * 表格合并用
     */
    private int idx;
    /**
     * 标准项idf
     */
    @ApiModelProperty(value = "ID")
    private Long standardId;
    /**
     * 父菜单ID
     */
    private Long parentId;

    /**
     * 验收内容统计
     */
    private Long demandTotal;
    /**
     * 验收记录统计
     */
    private Long recordTotal;
    /**
     * 验收类型（竣工查验、消防检测、现场评定）
     */
    @Excel(name = "验收类型")
    @ApiModelProperty(value = "验收类型")
    private String type;
    /**
     * 标准项名称
     */
    @Excel(name = "标准项名称")
    @ApiModelProperty(value = "标准项名称")
    private String name;
    private String checkCategory;
    /**
     * 标准项等级
     */
    @Excel(name = "标准项等级")
    @ApiModelProperty(value = "标准项等级")
    private Long level;
    /**
     * 验收内容
     */
    @Excel(name = "验收内容")
    @ApiModelProperty(value = "验收内容")
    private String acceptanceName;

    /**
     * 技术要求
     */
    @Excel(name = "技术要求")
    @ApiModelProperty(value = "技术要求")
    private String technicalReq;


    @Excel(name = "引用标准")
    @ApiModelProperty(value = "引用标准")
    private String standardReference;

    @Excel(name = "引用标准名称")
    @ApiModelProperty(value = "引用标准")
    private String standardReferenceName;

    @Excel(name = "引用标准名称集合")
    @ApiModelProperty(value = "引用标准集合")
    private Set<String> standardReferenceNameList;

    private Long demandId;
    /**
     * 任务记录id
     */
    @ApiModelProperty(value = "任务记录id")
    private Long recordId;

    /**
     * 项目id
     */
    @Excel(name = "项目id")
    @ApiModelProperty(value = "项目id")
    private Long projectId;
    /**
     * 检查部位
     */
    @Excel(name = "检查部位")
    @ApiModelProperty(value = "检查部位")
    private String checkPart;
    /**
     * 检查数量
     */
    @Excel(name = "检查数量")
    @ApiModelProperty(value = "检查数量")
    private String checkNumber;

    /**
     * 验收内容
     */
    @Excel(name = "验收内容")
    @ApiModelProperty(value = "验收内容")
    private String accContent;
    /**
     * 检查附件
     */
    @Excel(name = "检查附件")
    @ApiModelProperty(value = "检查附件")
    private String checkFile;
    /**
     * 重要程度
     */
    @Excel(name = "重要程度")
    @ApiModelProperty(value = "重要程度")
    private String important;


    /**
     * 查验结论(评定时使用)
     */
    @Excel(name = "查验结论(评定时使用)")
    @ApiModelProperty(value = "查验结论(评定时使用)")
    private String completionSummary;

    /**
     * 检测结论（评定时使用）
     */
    @Excel(name = "检测结论", readConverterExp = "评定时使用")
    @ApiModelProperty(value = "检测结论")
    private String firecheckSummary;
    /**
     * 检查总结
     */
    @Excel(name = "检查总结")
    @ApiModelProperty(value = "检查总结")
    private String checkSummary;

    /**
     * 检查总结
     */
    @Excel(name = "检查总结")
    @ApiModelProperty(value = "检查总结")
    private String checkSummaryName;

    /**
     * 检查记录
     */
    @Excel(name = "检查记录")
    @ApiModelProperty(value = "检查记录")
    private String checkRecord;

    /**
     * 检查时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "检查时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "检查时间")
    private Date checkTime;

    /**
     * 检查人员
     */
    @Excel(name = "检查人员")
    @ApiModelProperty(value = "检查人员")
    private String checkPerson;

    /**
     * 检查人员
     */
    @Excel(name = "检查人员Ids")
    @ApiModelProperty(value = "检查人员Ids")
    private String checkPersonIds;

    @Excel(name = "审查结论")
    @ApiModelProperty(value = "审查结论")
    private String auditSummary;

    @Excel(name = "附件视频")
    @ApiModelProperty(value = "附件视频")
    private String checkFileVideo;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TStandardCategoryRecordVo> children;


    private Map<String, Object> objectMap;

    /**
     * 验收部位
     */
    private HashSet<String> checkPartList;

    /**
     * 验收人员
     */
    private  HashSet<String> checkPersonIdsList;
}
