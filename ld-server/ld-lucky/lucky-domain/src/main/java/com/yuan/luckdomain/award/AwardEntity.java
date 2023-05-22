package com.yuan.luckdomain.award;

import com.alibaba.cola.domain.Entity;
import com.yuan.luckdomain.rule.MinNumber;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Ykj
 * @date 2023/4/11/16:03
 * @apiNote
 */
@Entity
@Data
public class AwardEntity {
  
   private Long id;
   
   /**
    *
    */
   private Long prizeId;
   private Long activityId;
   /**
    *
    */
   private AwardNumber number;
   
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
   
   public Boolean isPrize(){
      return !"0".equals(this.prizeId.toString());
      //return this.prizeId!=0L;
   }
}
