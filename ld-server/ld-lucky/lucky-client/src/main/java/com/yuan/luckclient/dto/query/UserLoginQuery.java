package com.yuan.luckclient.dto.query;

import com.alibaba.cola.dto.Query;
import lombok.Data;

/**
 * @author Ykj
 * @date 2023/3/20/19:02
 * @apiNote
 */
@Data
public class UserLoginQuery extends Query {
   
   private String username;
   
   private String password;
   
   
}
