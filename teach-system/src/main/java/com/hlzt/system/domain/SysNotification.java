package com.hlzt.system.domain;

import com.hlzt.common.annotation.Dict;
import com.hlzt.common.annotation.Excel;
import com.hlzt.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Size;

/**
 * 消息通知对象 sys_notification
 *
 * @author dengyy
 * @date 2021-06-02
 */
@Data
@Accessors(chain = true)
@ApiModel("消息通知")
public class SysNotification extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 公告ID
     */
    @ApiModelProperty(value = "ID")
    private Long notificationId;

    /**
     * 消息标题
     */
    @Excel(name = "消息标题")
    @ApiModelProperty(value = "消息标题")
    @Size(min = 0, max = 100, message = "消息标题长度不能超过100个字符")
    private String notificationTitle;

    /**
     * 消息类型（1任务安排）
     */
    @Excel(name = "消息类型", readConverterExp = "1=任务安排")
    @Dict(dictValue = "notification_type")
    @ApiModelProperty(value = "消息类型")
    private String notificationType;
    private String notificationTypeDictLabel;

    /**
     * 封面图片
     */
    @ApiModelProperty(value = "封面图片")
    private String poster;

    /**
     * 消息内容
     */
    @Excel(name = "消息内容")
    @ApiModelProperty(value = "消息内容")
    private String notificationContent;

    /**
     * 消息状态（0正常 1关闭）
     */
    @Excel(name = "消息状态", readConverterExp = "0=正常,1=关闭")
    @Dict(dictValue = "sys_normal_disable")
    @ApiModelProperty(value = "消息状态")
    private String status;
    private String statusDictLabel;

    /**
     * 推送人
     */
    @Excel(name = "推送人")
    @ApiModelProperty(value = "推送人")
    @Dict(dictTable = "sys_user", dictValue = "user_id", dictLabel = "nick_name")
    private Long pusher;
    private String pusherDictLabel;

    /**
     * 推送状态（1已推送，2未推送，3推送失败，推送成功）
     */
    @Excel(name = "推送状态", readConverterExp = "1=已推送，2未推送，3推送失败，推送成功")
    @Dict(dictValue = "message_push_state")
    @ApiModelProperty(value = "推送状态")
    private String pushState;
    private String pushStateDictLabel;

    /**
     * 接收人
     */
    @Excel(name = "接收人")
    @ApiModelProperty(value = "接收人")
    @Dict(dictTable = "sys_user", dictValue = "user_id", dictLabel = "nick_name")
    private Long receiver;
    private String receiverDictLabel;


    @Excel(name = "接收部门")
    @ApiModelProperty(value = "接收部门")
    private String receiverDept;

    /**
     * 接收状态（1已接收，未接收）
     */
    @Excel(name = "接收状态", readConverterExp = "1=已接收，未接收")
    @Dict(dictValue = "message_reciver_state")
    @ApiModelProperty(value = "接收状态")
    private String receiverState;
    private String receiverStateDictLabel;


    private String editStatus;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("notificationId", getNotificationId())
                .append("notificationTitle", getNotificationTitle())
                .append("notificationType", getNotificationType())
                .append("notificationContent", getNotificationContent())
                .append("status", getStatus())
                .append("pusher", getPusher())
                .append("pushState", getPushState())
                .append("receiver", getReceiver())
                .append("receiverState", getReceiverState())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
