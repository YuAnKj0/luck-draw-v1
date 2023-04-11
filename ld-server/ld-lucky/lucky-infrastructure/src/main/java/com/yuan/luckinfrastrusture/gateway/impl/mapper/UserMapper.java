package com.yuan.luckinfrastrusture.gateway.impl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.luckclient.service.dto.query.UserListByParamQuery;
import com.yuan.luckdomain.user.UserEntity;
import com.yuan.luckinfrastrusture.gateway.impl.dataobject.UserDB;
import org.apache.ibatis.annotations.Param;


/**
* @author Ykj
* @description 针对表【ldb_user】的数据库操作Mapper
* @createDate 2023-03-20 15:19:36
* @Entity com.yuan.user.po.User
*/
public interface UserMapper extends BaseMapper<UserDB> {
    
    /**
     * @param id 
     * @param userName
     * @return
     */
    UserDB findByUserName(@Param("id")Long id,@Param("name") String userName);
    
    IPage<UserDB> findByParam(@Param("userEntityPage") Page<UserEntity> userEntityPage, @Param("query") UserListByParamQuery query);
}




