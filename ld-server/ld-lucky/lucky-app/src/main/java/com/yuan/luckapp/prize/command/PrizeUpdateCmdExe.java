package com.yuan.luckapp.prize.command;

import com.yuan.luckapp.assembler.PrizeAssembler;
import com.yuan.luckclient.service.dto.PrizeUpdateCmd;
import com.yuan.luckclient.service.dto.data.PrizeVO;
import com.yuan.luckdomain.gateway.PrizeGateway;
import com.yuan.luckdomain.prize.PrizeEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Ykj
 * @date 2023/4/10/16:44
 * @apiNote
 */
@Slf4j
@Component
@AllArgsConstructor
public class PrizeUpdateCmdExe {
   private final PrizeGateway prizeGateway;
   public PrizeVO excute(PrizeUpdateCmd cmd) {
      PrizeEntity prizeEntity = prizeGateway.save(PrizeAssembler.toUpdateEntity(cmd));
      return PrizeAssembler.toPrizeVO(prizeEntity);
   }
}
