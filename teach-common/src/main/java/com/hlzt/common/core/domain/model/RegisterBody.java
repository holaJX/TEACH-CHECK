package com.hlzt.common.core.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户注册对象
 *
 * @author hlzt-dyy
 */
@Data
@ApiModel("用户注册对象")
public class RegisterBody {

    @ApiModelProperty(value = "单位名称")
    private String deptName;
    /**
     * 区划代码
     */
    @ApiModelProperty(value = "区划代码")
    private String districtCode;
    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String detailedAddress;
    /**
     * 统一社会信用代码
     */
    @ApiModelProperty(value = "统一社会信用代码")
    private String creditCode;
    /**
     * 部门ID
     */
    @ApiModelProperty(value = "单位类型(父ID)")
    private Long parentId;
    /**
     * 部门ID
     */
    @ApiModelProperty(value = "部门ID")
    private Long deptId;
    /**
     * 营业执照图片地址
     */
    @ApiModelProperty(value = "营业执照图片地址")
    private String licenseUrl;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "用户姓名")
    private String nickName;
    /**
     * 联系人员
     */
    @ApiModelProperty(value = "联系人员")
    private String leader;
    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private String phone;
    /**
     * 电话号码
     */
    @ApiModelProperty(value = "电话号码")
    private String phonenumber;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;
    /**
     * 图片验证码
     */
    @ApiModelProperty(value = "图片验证码")
    private String code;
    /**
     * 图片验证码ID
     */
    @ApiModelProperty(value = "图片验证码ID")
    private String uuid;
    /**
     * 联系人姓名
     */
    @ApiModelProperty(value = "联系人姓名")
    private String linkName;
    /**
     * 联系人电话
     */
    @ApiModelProperty(value = "联系人电话")
    private String linkPhone;


}
