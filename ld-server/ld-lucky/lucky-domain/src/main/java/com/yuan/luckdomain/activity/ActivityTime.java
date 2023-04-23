package com.yuan.luckdomain.activity;

import com.yuan.base.config.exception.LDException;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Ykj
 * @date 2023/4/21/11:43
 * @apiNote
 */
@Getter
public class ActivityTime {
   
   private LocalDateTime startTime;
   
   private LocalDateTime endTime;
   
   public ActivityTime(LocalDateTime startTime, LocalDateTime endTime) {
      if (Objects.isNull(startTime)||Objects.isNull(endTime)){
         throw new LDException("时间不为空");
      }
      if (startTime.isAfter(endTime)){
         throw new LDException("非法的活动时间");
      }
      
      this.startTime = startTime;
      this.endTime = endTime;
   }
   public ActivityStatusEnum getStatus(){
      return getStatus(LocalDateTime.now());
      
   }
   
   public ActivityStatusEnum getStatus(LocalDateTime now){
       if (now.isBefore(this.startTime)){
          return ActivityStatusEnum.NOT_START;
       }
      if (now.isAfter(this.startTime)&&now.isBefore(this.endTime)){
         return ActivityStatusEnum.START;
      }
      return ActivityStatusEnum.END;
   }
}
