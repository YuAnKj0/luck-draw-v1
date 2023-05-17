package com.yuan.luckapp.award.command;

import com.yuan.luckapp.assembler.AwardAssembler;
import com.yuan.luckclient.service.dto.AwardUpdateCmd;
import com.yuan.luckclient.service.dto.data.AwardVO;
import com.yuan.luckdomain.award.AwardEntity;
import com.yuan.luckdomain.gateway.AwardGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Ykj
 * @date 2023/4/11/17:37
 * @apiNote
 */
@Slf4j
@Component
@AllArgsConstructor
public class AwardUpdateCmdExe {
    private final AwardGateway gateway;
    public AwardVO excute(AwardUpdateCmd cmd) {
        AwardEntity entity = gateway.save(AwardAssembler.toUpdateEntity(cmd));
        return AwardAssembler.toAwardVO(entity);
    }
    
}
