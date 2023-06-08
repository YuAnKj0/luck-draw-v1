package com.yuan.luckclient.service.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;

@Data
public class RecordAddCmd  extends Command {
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
    
    /**
     * 是否中奖：0未中奖，1中奖
     */
    private Integer isWinning;
    
    /**
     * 状态（0，1，2，3）
     */
    private Integer state;
}