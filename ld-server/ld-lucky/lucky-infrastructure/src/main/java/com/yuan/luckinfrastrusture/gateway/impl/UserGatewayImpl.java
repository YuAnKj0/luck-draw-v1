package com.yuan.luckinfrastrusture.gateway.impl;

import com.alibaba.cola.exception.SysException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.base.config.enums.LDExceptionEnum;
import com.yuan.base.config.utils.AssertUtil;
import com.yuan.luckclient.service.dto.query.UserListByParamQuery;
import com.yuan.luckdomain.gateway.UserGateway;
import com.yuan.luckdomain.user.UserEntity;
import com.yuan.luckinfrastrusture.convertor.UserConvertor;
import com.yuan.luckinfrastrusture.gateway.impl.dataobject.UserDB;
import com.yuan.luckinfrastrusture.gateway.impl.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author Ykj
 * @date 2023/3/27/14:57
 * @apiNote
 */
@Slf4j
@Component
@AllArgsConstructor
public class UserGatewayImpl implements UserGateway {
   private final UserMapper userMapper;
   @Override
   public UserEntity findByUserName(Long id, String userName) {
      UserDB userDB = userMapper.findByUserName(id, userName);      
      if (Objects.isNull(userDB)){
         return null;
      }
      return UserConvertor.toEntity(userDB);
   }
   
   @Override
   public UserEntity save(UserEntity userEntity) {
      if (Objects.isNull(userEntity.getId())) {
         return addUser(userEntity);
      }
      return updateUser(userEntity);
      
   }
   
   @Override
   public IPage<UserEntity> findByParam(UserListByParamQuery query) {
      IPage<UserDB> userDBIPage = userMapper.findByParam(new Page<UserEntity>(query.getPageIndex(), query.getPageSize()), query);
      return userDBIPage.convert(UserConvertor::toEntity);
   }
   
   public UserEntity addUser(UserEntity userEntity) {
      UserDB userDB= UserConvertor.toUserDB(userEntity);
      AssertUtil.isTrue(userMapper.insert(userDB)<=0, LDExceptionEnum.ADD_USER_ERROR.getDescription());
      return UserConvertor.toEntity(userDB);
   }
   public UserEntity updateUser(UserEntity userEntity) {
      UserDB userDB= UserConvertor.toUserDB(userEntity);
      AssertUtil.isTrue(userMapper.updateById(userDB)<=0,LDExceptionEnum.UPDATE_USER_ERROR.getDescription());
      return UserConvertor.toEntity(userDB);
   }
   
}
