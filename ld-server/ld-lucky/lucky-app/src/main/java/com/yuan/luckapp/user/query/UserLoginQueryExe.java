package com.yuan.luckapp.user.query;

import com.alibaba.cola.exception.SysException;
import com.yuan.luckapp.assembler.UserAssembler;
import com.yuan.luckclient.service.dto.data.UserVO;
import com.yuan.luckclient.service.dto.query.UserLoginQuery;
import com.yuan.luckdomain.gateway.UserGateway;
import com.yuan.luckdomain.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author Ykj
 * @date 2023/3/29/14:27
 * @apiNote
 */
@Slf4j
@Component
@AllArgsConstructor
public class UserLoginQueryExe {
   
   private final UserGateway userGateway;
   public UserVO execute(UserLoginQuery query) {
      UserEntity userEntity=userGateway.findByUserName(null,query.getUsername());
      if (Objects.isNull(userEntity)){
         throw new SysException("登录失败，用户不存在");

      }
      if (Boolean.FALSE.equals(userEntity.getPassword().isEqual(query.getPassword()))) {
         throw new SysException("登录失败，密码错误");
      }
      return UserAssembler.toUserVO(userEntity);
   }
}
