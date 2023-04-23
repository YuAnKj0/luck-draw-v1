package com.yuan.luckclient.service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;



/**
 * @author Ykj
 * @date 2023/4/21/17:08
 * @apiNote
 */
@Data
public class ActivityUpdateCmd {
   @NotNull(message ="活动id不为空" )
   private Long id;
   @NotNull(message ="活动名称不为空" )
   private String activityName;
   @NotNull(message ="活动开始时间不为空" )
   private LocalDateTime startTime;
   @NotNull(message ="活动结束时间不为空" )
   private LocalDateTime endTime;
   @NotNull(message ="活动描述不为空" )
   private String describe;
}
