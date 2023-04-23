package com.yuan.luckclient.service.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Ykj
 * @date 2023/4/21/17:10
 * @apiNote
 */
@Data
public class ActivityListByParamQuery extends PageQuery {
   private Long id;
   private String activityName;
 
   private LocalDateTime startTime;

   private LocalDateTime endTime;
   
   /**
    * 活动状态（0,1,2）
    */
   private Integer status;
   
}
