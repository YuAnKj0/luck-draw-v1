package com.yuan.luck.user.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * @author Ykj
 * @date 2023/5/4/21:50
 * @apiNote 
 */

@Data
@TableName(value = "ld_activity_rule")
public class ActivityRule implements Serializable {
    @TableId(value = "id", type = IdType.INPUT)

    @NotNull(message = "不能为null")
    private Long id;

    /**
     * 活动id
     */
    @TableField(value = "activity_id")

    @NotNull(message = "活动id不能为null")
    private Long activityId;

    /**
     * 规则id
     */
    @TableField(value = "rule_id")

    @NotNull(message = "规则id不能为null")
    private Long ruleId;

    @TableField(value = "create_time")

    private Date createTime;

    @TableField(value = "creator")

    @Size(max = 10,message = "最大长度要小于 10")
    private String creator;

    @TableField(value = "update_time")

    private Date updateTime;

    @TableField(value = "updater")

    @Size(max = 10,message = "最大长度要小于 10")
    private String updater;


}