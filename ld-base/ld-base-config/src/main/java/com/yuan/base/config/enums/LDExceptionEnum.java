package com.yuan.base.config.enums;

import com.yuan.base.config.vo.FailInfo;
import lombok.Getter;

/**
 * @author Ykj
 * @date 2023/4/23/10:53
 * @apiNote
 */
@Getter
public enum LDExceptionEnum {
   ADD_ERROR(FailInfo.DEFAULT_CODE,"保存数据失败"),
   UPDATE_ERROR(FailInfo.DEFAULT_CODE,"修改数据失败"),
   ADD_USER_ERROR(FailInfo.DEFAULT_CODE,"注册用户失败"),
   UPDATE_USER_ERROR(FailInfo.DEFAULT_CODE,"修改用户数据失败"),
   ;
   
   private Integer code;

   private String description;
   
   LDExceptionEnum(Integer code,String description){
      this.code = code;
      this.description = description;
      
   }
}
