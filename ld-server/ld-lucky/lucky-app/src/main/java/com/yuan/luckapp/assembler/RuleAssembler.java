package com.yuan.luckapp.assembler;
import com.yuan.base.config.utils.SecurityUtil;
import com.yuan.luckdomain.rule.MinNumber;
import java.time.LocalDateTime;

import com.yuan.luckclient.service.dto.RuleAddCmd;
import com.yuan.luckclient.service.dto.RuleUpdateCmd;
import com.yuan.luckclient.service.dto.data.RuleVO;
import com.yuan.luckdomain.prize.PrizeEntity;
import com.yuan.luckdomain.rule.RuleEntity;
import org.apache.commons.digester.Rule;

/**
 * @author Ykj
 * @date 2023/4/11/11:45
 * @apiNote
 */
public class RuleAssembler {
    
    
    public static RuleEntity toAddEntity(RuleAddCmd cmd) {
        RuleEntity entity = new RuleEntity();
        entity.setRuleName(cmd.getRuleName());
        entity.setMaxJoinNumber(new MinNumber(cmd.getMaxJoinNumber()));
        entity.setMaxWiningNumber(new MinNumber(cmd.getMaxWiningNumber()));
        entity.setCreateTime(LocalDateTime.now());
        entity.setCreator(SecurityUtil.getName());
        entity.setUpdateTime(LocalDateTime.now());
        entity.setUpdater(SecurityUtil.getName());
        
        return entity;
    }
    
    public static RuleVO toRuleVO(RuleEntity entity) {
        RuleVO ruleVO = new RuleVO();
        ruleVO.setId(entity.getId());
        ruleVO.setRuleName(entity.getRuleName());
        ruleVO.setMaxJoinNumber(entity.getMaxJoinNumber().getNumber());
        ruleVO.setMaxWiningNumber(entity.getMaxWiningNumber().getNumber());
        ruleVO.setCreateTime(entity.getCreateTime());
        ruleVO.setCreator(entity.getCreator());
        ruleVO.setUpdateTime(entity.getUpdateTime());
        ruleVO.setUpdater(entity.getUpdater());
        return ruleVO;
    }
    
    public static RuleEntity toUpdateEntity(RuleUpdateCmd cmd) {
        RuleEntity entity = new RuleEntity();
        entity.setId(cmd.getId());
        entity.setRuleName(cmd.getRuleName());
        entity.setMaxJoinNumber(new MinNumber(cmd.getMaxJoinNumber()));
        entity.setMaxWiningNumber(new MinNumber(cmd.getMaxWiningNumber()));
        entity.setUpdateTime(LocalDateTime.now());
        entity.setUpdater(SecurityUtil.getName());
        return entity;
        
    }
}
