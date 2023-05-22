package com.yuan.luckclient.service.dto.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Ykj
 * @date 2023/4/25/16:30
 * @apiNote
 */


@Data
@AllArgsConstructor
public class ActivityConfigVO {
    
    private ActivityVO activityVO;
    
    private List<RuleVO> ruleVOList;
    
    private List<AwardVO> awardVOList;
}
