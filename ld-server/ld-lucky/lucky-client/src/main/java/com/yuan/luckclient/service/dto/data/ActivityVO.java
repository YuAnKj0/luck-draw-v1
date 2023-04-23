package com.yuan.luckclient.service.dto.data;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Ykj
 * @date 2023/4/12/16:11
 * @apiNote
 */
@Data
public class ActivityVO {
   private Long id;
   
   private String activityName;
   
   private LocalDateTime startTime;
   
   private LocalDateTime endTime;
   
   private String describe;
   /**
    * 0,未开始，1，进行中，2已结束
    */
   private Integer status;
   
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
   
   /**
    *
    */
   private String updater;
}
