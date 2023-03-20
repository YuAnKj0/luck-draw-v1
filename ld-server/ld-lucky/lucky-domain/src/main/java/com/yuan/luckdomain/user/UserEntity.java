package com.yuan.luckdomain.user;

import com.alibaba.cola.domain.Entity;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Ykj
 * @date 2023/3/20/15:45
 * @apiNote
 */

@Data
@Entity
public class UserEntity {
   /**
    * 账号
    */

   private Long id;
   
   /**
    *
    */
   private UserName username;
   
   /**
    *
    */
   private PassWord password;
   
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
