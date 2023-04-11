package com.yuan.luckapp.rule.command;

import com.yuan.luckapp.assembler.RuleAssembler;
import com.yuan.luckclient.service.dto.RuleUpdateCmd;
import com.yuan.luckclient.service.dto.data.RuleVO;
import com.yuan.luckdomain.gateway.RuleGateway;
import com.yuan.luckdomain.rule.RuleEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Ykj
 * @date 2023/4/11/11:33
 * @apiNote
 */
@Slf4j
@Component
@AllArgsConstructor
public class RuleUpdateCmdExe {
    private final RuleGateway ruleGateway;
    public RuleVO excute(RuleUpdateCmd cmd) {
        RuleEntity entity = ruleGateway.save(RuleAssembler.toUpdateEntity(cmd));
        return RuleAssembler.toRuleVO(entity);
    }
}
