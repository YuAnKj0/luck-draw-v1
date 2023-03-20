package com.yuan.user.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName ldb_activity
 */
@TableName(value ="ldb_activity")
@Data
public class Activity implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private String activityName;

    /**
     * 
     */
    private LocalDateTime startTime;

    /**
     * 
     */
    private LocalDateTime endTime;

    /**
     * 
     */
    private String describe;
    
    
    @TableField(fill = FieldFill.INSERT)    
    private LocalDateTime createTime;

    /**
     * 
     */
    private String creator;
    
    
    @TableField(fill = FieldFill.INSERT_UPDATE)  
    private LocalDateTime updateTime;

    /**
     * 
     */
    private String updater;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}