package com.yuan.luckinfrastrusture.gateway.impl.dataobject;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName ldb_record
 */
@TableName(value ="ldb_record")
@Data
public class RecordDB implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private Long activityId;

    /**
     * 
     */
    private Long awardId;

    /**
     * 是否中奖：（0,1）默认非中奖0
     */
    private Integer isWining;

    /**
     * 状态：0,1,2,3
     */
    private Integer state;

    /**
     * 
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 
     */
    private String creator;

    /**
     * 
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 
     */
    private String updater;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}