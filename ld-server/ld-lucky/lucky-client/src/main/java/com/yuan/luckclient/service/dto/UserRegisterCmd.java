package com.yuan.luckclient.service.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * @author Ykj
 * @date 2023/3/20/16:13
 * @apiNote
 */
@Data
public class UserRegisterCmd extends Command {
   
   /**
    * 账号
    */
   @NotNull(message = "账号不为空")
   private String username;
   
   @NotNull(message = "密码不为空")
   private String password;
   
   /**
    * 姓名
    */
   @NotNull(message = "姓名不为空")
   private String name;
   
   /**
    * 电话
    */
   @NotNull(message = "电话不为空")
   private String phone;
   
   
}
