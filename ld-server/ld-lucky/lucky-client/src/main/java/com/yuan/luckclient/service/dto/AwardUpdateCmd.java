package com.yuan.luckclient.service.dto;

import com.alibaba.cola.dto.Command;
import com.yuan.luckclient.service.dto.data.AwardVO;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author Ykj
 * @date 2023/4/11/16:11
 * @apiNote
 */
@Data
public class AwardUpdateCmd extends Command {
    
    @NotNull(message = "id不能为空")
    private Long id;
    
    
    @NotNull(message = "奖品id不能为空")
    private Long prizeId;
    @NotNull(message = "活动id不能为空")
    private Long activityId;
    
    /**
     *
     */
    @NotNull(message = "奖品数量不能为空")
    private Integer number;
    
    /**
     *
     */
    @NotNull(message = "奖品名称不能为空")
    private String awardName;
    
    /**
     * 概率
     */
    @NotNull(message = "概率不能为空")
    private Double probability;
}
