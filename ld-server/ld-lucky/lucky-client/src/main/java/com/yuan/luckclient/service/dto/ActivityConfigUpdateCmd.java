package com.yuan.luckclient.service.dto;

import com.yuan.luckclient.service.dto.data.ActivityVO;
import com.yuan.luckclient.service.dto.data.AwardVO;
import com.yuan.luckclient.service.dto.data.RuleVO;
import lombok.Data;

import java.util.List;

/**
 * @author Ykj
 * @date 2023/4/25/16:31
 * @apiNote
 */

@Data
public class ActivityConfigUpdateCmd {
    
    private ActivityUpdateCmd activityUpdateCmd;
    
    private List<Long> ruleIdList;
    
    private List<AwardUpdateCmd> awardUpdateCmdList;
}
