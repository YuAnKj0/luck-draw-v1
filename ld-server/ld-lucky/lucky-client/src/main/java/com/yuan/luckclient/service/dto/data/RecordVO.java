package com.yuan.luckclient.service.dto.data;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Ykj
 * @date 2023/5/18/16:47
 * @apiNote
 */

@Data
public class RecordVO {
   

   private Long id;
   
   /**
    * 用户id
    */
   private Long userId;
   
   /**
    * 活动id
    */
   private Long activityId;
   
   private String activityName;
   
   /**
    * 奖项id
    */
   private Long awardId;
   
   private String awardName;
   
   private String prizeName;
   
   private Integer prizeType;
   
   
   /**
    * 是否中奖：0未中奖，1中奖
    */
   private Integer isWinning;
   
   /**
    * 状态（0，1，2，3）
    */
   private Integer state;
   
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
