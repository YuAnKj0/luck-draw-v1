package com.yuan.user.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName ldb_prize
 */
@TableName(value ="ldb_prize")
@Data
public class Prize implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 奖品名称
     */
    private String prizeName;

    /**
     * 库存
     */
    private Integer inventory;

    /**
     * 
     */
    private BigDecimal money;

    /**
     * 
     */
    private Integer type;

    /**
     * 
     */
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