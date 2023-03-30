package com.yuan.luckapp.user.command;

import com.yuan.luckapp.assembler.UserAssembler;
import com.yuan.luckclient.service.dto.UserUpdateCmd;
import com.yuan.luckclient.service.dto.data.UserVO;
import com.yuan.luckdomain.gateway.UserGateway;
import com.yuan.luckdomain.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Ykj
 * @date 2023/3/30/11:29
 * @apiNote
 */
@Slf4j
@Component
@AllArgsConstructor
public class UserUpdateCmdExe {
   private final UserGateway userGateway;
   public UserVO execute(UserUpdateCmd cmd) {
      UserEntity save = userGateway.save(UserAssembler.toUpdateEntity(cmd));
      return UserAssembler.toUserVO(save);
   }
}
