package com.yuan.luckclient.service.dto.data;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Ykj
 * @date 2023/4/11/16:06
 * @apiNote
 */
@Data
public class AwardVO {
   
   private Long id;
   
   /**
    *
    */
   private Long prizeId;

   private Long activityId;
   
   /**
    *
    */
   private Integer  number;
   
   /**
    *
    */
   private String awardName;
   
   /**
    * 概率
    */
   private Double probability;
   
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
