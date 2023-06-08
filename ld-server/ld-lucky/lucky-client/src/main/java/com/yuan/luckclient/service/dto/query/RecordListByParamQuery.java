package com.yuan.luckclient.service.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * @author Ykj
 * @date 2023/5/18/16:37
 * @apiNote
 */


@Data
@Accessors(chain = true)
public class RecordListByParamQuery extends PageQuery {
   
   private Long activityId;
   
   private Long activityName;
   
   /**
    * 用户id
    */
   private Long userId;
   
   /**
    * 抽奖结果
    */
   private Integer results;
   
   /**
    *
    */
   private LocalDate startTime;
   
   private LocalDate endTime;
   
}
