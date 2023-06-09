package com.yuan.luck.user.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName ldb_accept_prize
 */
@TableName(value ="ldb_accept_prize")
@Data
public class AcceptPrize implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long recordId;

    /**
     * 
     */
    private String phone;

    /**
     * 
     */
    private String address;
    
    
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