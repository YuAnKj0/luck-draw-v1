package com.yuan.luckclient.service.dto.data;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Ykj
 * @date 2023/3/20/16:10
 * @apiNote
 */
@Data
public class UserVO {
   /**
    * 账号
    */
   
   private Long id;
   
   /**
    *
    */
   private String username;

   private String name;
   
   /**
    *
    */
   private String phone;
   
   /**
    *
    */
   
   private LocalDateTime createTime;
   
   /**
    *
    */
   private String creator;
   
   /**
    *
    */
   private LocalDateTime updateTime;
}
