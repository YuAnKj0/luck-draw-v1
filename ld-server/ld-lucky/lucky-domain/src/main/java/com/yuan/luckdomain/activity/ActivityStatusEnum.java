package com.yuan.luckdomain.activity;


import lombok.Getter;

@Getter
/**
 * @author Ykj
 * @date 2023/4/21/11:47
 * @apiNote
 */
public enum ActivityStatusEnum {
   NOT_START(0,"未开始"),
   START(1,"进行中"),
   END(2,"已结束"),
   ;
   
   private Integer value;
   
   private String description;
   
  ActivityStatusEnum(Integer value, String description) {
      this.value = value;
      this.description = description;
   }
   
}
