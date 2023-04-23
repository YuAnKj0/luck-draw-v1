package com.yuan.luckdomain.activity;

import com.alibaba.cola.domain.Entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Ykj
 * @date 2023/4/12/16:09
 * @apiNote
 */
@Entity
@Data
public class ActivityEntity {
   @TableId(type = IdType.AUTO)
   private Long id;
   
   private String activityName;
   
   /**
    * 活动时间
    */
   private ActivityTime activityTime;
   
   /**
    * 描述
    */
   private String describe;
   
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


