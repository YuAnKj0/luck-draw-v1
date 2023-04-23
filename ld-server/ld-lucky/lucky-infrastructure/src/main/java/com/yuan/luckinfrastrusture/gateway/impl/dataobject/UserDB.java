package com.yuan.luckinfrastrusture.gateway.impl.dataobject;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Ykj
 * @date 2023/3/20/15:35
 * @apiNote
 */
@TableName(value ="bld_user")
@Data
public class UserDB implements Serializable {
   /**
    * 账号
    */
   @TableId(type = IdType.AUTO)
   private Long id;
   
   /**
    *
    */
   private String username;
   
   /**
    *
    */
   private String password;
   
   /**
    *
    */
   private String name;
   
   /**
    *
    */
   private String phone;
   
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
