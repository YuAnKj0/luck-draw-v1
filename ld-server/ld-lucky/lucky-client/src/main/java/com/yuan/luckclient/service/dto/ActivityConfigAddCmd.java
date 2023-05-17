package com.yuan.luckclient.service.dto;

import com.yuan.luckclient.service.dto.data.ActivityConfigVO;
import com.yuan.luckclient.service.dto.data.ActivityVO;
import com.yuan.luckclient.service.dto.data.AwardVO;
import com.yuan.luckclient.service.dto.data.RuleVO;
import lombok.Data;

import java.util.List;

/**
 * @author Ykj
 * @date 2023/4/25/16:30
 * @apiNote
 */

@Data
public class ActivityConfigAddCmd {
    
    private ActivityAddCmd activityAddCmd;
    
    private List<Long> ruleIdList;
    
    private List<AwardAddCmd> awardAddCmdList;
}
