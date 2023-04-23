package com.yuan.luckclient.service.dto;

import com.alibaba.cola.dto.Command;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ActivityAddCmd extends Command {
   
   @NotNull(message ="活动名称不为空" )
   private String activityName;
   @NotNull(message ="活动开始时间不为空" )
   private LocalDateTime startTime;
   @NotNull(message ="活动结束时间不为空" )
   private LocalDateTime endTime;
   @NotNull(message ="活动描述不为空" )
   private String describe;
}