package com.yuan.luckclient.service.dto.query;

import com.alibaba.cola.dto.Query;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Ykj
 * @date 2023/3/20/19:02
 * @apiNote
 */
@Data
public class UserLoginQuery extends Query {
   
   @NotNull(message = "账号不为空")
   private String username;
   @NotNull(message = "密码不为空")
   private String password;
   
   
}
