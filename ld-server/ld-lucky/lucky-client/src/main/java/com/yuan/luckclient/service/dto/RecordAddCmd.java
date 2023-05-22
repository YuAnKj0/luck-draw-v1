package com.yuan.luckclient.service.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;

@Data
public class RecordAddCmd  extends Command {
    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 抽奖结果(0:未中奖，1:中奖)
     */
    private Integer results;

    private Long awardId;
}