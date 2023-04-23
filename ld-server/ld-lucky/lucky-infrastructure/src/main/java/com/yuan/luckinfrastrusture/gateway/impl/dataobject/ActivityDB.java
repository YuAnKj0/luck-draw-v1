package com.yuan.luckinfrastrusture.gateway.impl.dataobject;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName ldb_activity
 */
@TableName(value ="bld_activity")
@Data
public class ActivityDB implements Serializable {
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