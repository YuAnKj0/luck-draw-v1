package com.yuan.luckclient.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckclient.dto.UserRegisterCmd;
import com.yuan.luckclient.dto.UserUpdateCmd;
import com.yuan.luckclient.dto.data.UserVO;
import com.yuan.luckclient.dto.query.UserListByParamQuery;
import com.yuan.luckclient.dto.query.UserLoginQuery;


/**
 * @author Ykj
 * @date 2023/3/20/16:12
 * @apiNote
 */
public interface IUserService{
    
    //注册、列表、查询一个、登录
    
    /**
     * 用户注册
     * @param cmd
     * @return
     */
    UserVO register(UserRegisterCmd cmd);
    
    /**
     * 用户登录
     * @param query
     * @return
     */
    UserVO login(UserLoginQuery query);
    
    /**
     * 分页查询
     * @param query
     * @return
     */
    IPage<UserVO> page(UserListByParamQuery query);
    
   
    UserVO ont(Long userId);
    
    UserVO update(UserUpdateCmd cmd);
}
