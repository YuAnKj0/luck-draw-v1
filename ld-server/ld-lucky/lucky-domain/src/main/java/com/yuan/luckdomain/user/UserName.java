package com.yuan.luckdomain.user;

import com.yuan.config.exception.LDException;
import lombok.Getter;

import java.util.Objects;

/**
 * @author Ykj
 * @date 2023/3/20/15:47
 * @apiNote
 */

@Getter
public class UserName {
   
   private String username;
   
   public UserName(String username) {
      if (Objects.isNull(username)) {
         throw new LDException("账号不能为空");
   
      }     
      this.username = username;
   }
}
