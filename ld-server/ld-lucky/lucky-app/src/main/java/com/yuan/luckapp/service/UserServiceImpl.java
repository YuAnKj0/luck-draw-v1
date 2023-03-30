package com.yuan.luckapp.service;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.base.config.exception.LDException;
import com.yuan.base.config.utils.JwtUtil;
import com.yuan.luckapp.user.command.UserUpdateCmdExe;
import com.yuan.luckapp.user.query.UserListByParamQueryExe;
import com.yuan.luckclient.service.api.IUserService;
import com.yuan.luckclient.service.dto.UserRegisterCmd;
import com.yuan.luckclient.service.dto.UserUpdateCmd;
import com.yuan.luckclient.service.dto.data.UserVO;
import com.yuan.luckclient.service.dto.query.UserListByParamQuery;
import com.yuan.luckclient.service.dto.query.UserLoginQuery;
import com.yuan.luckapp.user.command.UserRegisterCmdExe;

import com.yuan.luckapp.user.query.UserLoginQueryExe;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Ykj
 * @date 2023/3/27/13:48
 * @apiNote
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
   
   /**
    * 构造器注入，危险就是循环依赖不能解决，交给工程师自己解决
    * 体现就是高度内聚
    */
   private final UserRegisterCmdExe userRegisterCmdExe;
   private final UserLoginQueryExe userLoginQueryExe;
   private final UserListByParamQueryExe userListByParamQueryExe;
   private final UserUpdateCmdExe userUpdateCmdExe;
   /**
    * 用户注册
    *
    * @param cmd
    * @return
    */
   @Override
   public UserVO register(UserRegisterCmd cmd) {
      return userRegisterCmdExe.execute(cmd);
   }
   
   /**
    * 用户登录
    *
    * @param query
    * @return
    */
   @Override
   public String login(UserLoginQuery query) {
      UserVO userVO = userLoginQueryExe.execute(query);
      //jwt
      return JwtUtil.createToken(Map.of(
              "username",userVO.getUsername(),
              "name",userVO.getName(),
              "phone",userVO.getPhone(),
              "id",userVO.getId()
      ));
   }
   
   /**
    * 分页查询
    *
    * @param query
    * @return
    */
   @Override
   public IPage<UserVO> page(UserListByParamQuery query) {
      return userListByParamQueryExe.execute(query);
   }
   
   @Override
   public UserVO one(Long userId) {
      final var query = new UserListByParamQuery();
      query.setId(userId);
      
      IPage<UserVO> iPage =  userListByParamQueryExe.execute(query);
      if (CollUtil.isEmpty(iPage.getRecords())){
         throw new LDException("用户不存在");
      }
      return iPage.getRecords().get(0);
   }
   
   @Override
   public UserVO update(UserUpdateCmd cmd) {
      return  userUpdateCmdExe.execute(cmd);
   }
   
}
