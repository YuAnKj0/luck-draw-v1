package com.yuan.luckapp.user.command;

import com.alibaba.cola.exception.SysException;
import com.yuan.luckclient.service.dto.UserRegisterCmd;
import com.yuan.luckclient.service.dto.data.UserVO;
import com.yuan.luckdomain.gateway.UserGateway;
import com.yuan.luckdomain.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import com.yuan.luckapp.assembler.UserAssembler;

import java.util.Objects;

/**
 * @author Ykj
 * @date 2023/3/27/14:26
 * @apiNote
 */
@Slf4j
@Component
@AllArgsConstructor
public class UserRegisterCmdExe {
   
   private final UserGateway userGateway;
   
   public UserVO execute(UserRegisterCmd cmd){
      UserEntity lodEntity =userGateway.findByUserName(null, cmd.getUsername());
      if(Objects.nonNull(lodEntity)){
         throw new SysException("账号已存在");
         
      }
      UserEntity entity =userGateway.save(UserAssembler.toAddEntity(cmd));
      
      return UserAssembler.toUserVO(entity);
   }
}
