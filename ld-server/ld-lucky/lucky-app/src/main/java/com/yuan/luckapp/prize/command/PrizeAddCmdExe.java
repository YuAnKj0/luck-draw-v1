package com.yuan.luckapp.prize.command;

import com.yuan.luckapp.assembler.PrizeAssembler;
import com.yuan.luckclient.service.dto.PrizeAddCmd;
import com.yuan.luckclient.service.dto.data.PrizeVO;
import com.yuan.luckdomain.gateway.PrizeGateway;
import com.yuan.luckdomain.prize.PrizeEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Ykj
 * @date 2023/4/10/16:42
 * @apiNote
 */

@Slf4j
@Component
@AllArgsConstructor
public class PrizeAddCmdExe {
   private final PrizeGateway prizeGateway;
   
   public PrizeVO excute(PrizeAddCmd cmd) {
      PrizeEntity prizeEntity = prizeGateway.save(PrizeAssembler.toAddEntity(cmd));
      return PrizeAssembler.toPrizeVO(prizeEntity);
   }
}
