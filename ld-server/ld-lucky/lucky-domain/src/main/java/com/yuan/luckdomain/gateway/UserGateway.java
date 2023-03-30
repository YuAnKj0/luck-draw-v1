package com.yuan.luckdomain.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckclient.service.dto.query.UserListByParamQuery;
import com.yuan.luckdomain.user.UserEntity;

/**
 * @author Ykj
 * @date 2023/3/27/14:33
 * @apiNote 防腐层
 */

public interface UserGateway {
   
   UserEntity findByUserName(Long id,String userName);
   
   UserEntity save(UserEntity userEntity);
    
    IPage<UserEntity> findByParam(UserListByParamQuery query);
    
}
