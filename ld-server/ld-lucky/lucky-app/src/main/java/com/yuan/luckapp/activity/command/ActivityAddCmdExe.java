package com.yuan.luckapp.activity.command;

import com.yuan.luckapp.assembler.ActivityAssembler;
import com.yuan.luckclient.service.dto.ActivityAddCmd;
import com.yuan.luckclient.service.dto.data.ActivityVO;
import com.yuan.luckdomain.activity.ActivityEntity;
import com.yuan.luckdomain.gateway.ActivityGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@AllArgsConstructor
/**
 * @author Ykj
 * @date 2023/4/21/17:20
 * @apiNote
 */
public class ActivityAddCmdExe {
   private final ActivityGateway activityGateway;
   public ActivityVO excute(ActivityAddCmd cmd) {
      ActivityEntity entity = activityGateway.save(ActivityAssembler.toAddEntity(cmd));
      return ActivityAssembler.toActivityVO(entity);
   }
}
