package com.yuan.luckapp.record.command;

import com.yuan.luckapp.assembler.RecordAssembler;
import com.yuan.luckclient.service.dto.RecordAddCmd;
import com.yuan.luckclient.service.dto.data.RecordVO;
import com.yuan.luckdomain.gateway.RecordGateway;
import com.yuan.luckdomain.record.RecordEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Ykj
 * @date 2023/5/26/11:47
 * @apiNote
 */

@Slf4j
@Component
@AllArgsConstructor
public class RecordAddCmdExe {
   private final RecordGateway recordGateway;
   
   public RecordVO add(RecordAddCmd cmd) {
      RecordEntity entity=recordGateway.save(RecordAssembler.toAddEntity(cmd));
      return RecordAssembler.toRecordVO(entity);
   }
}
