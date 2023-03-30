package com.yuan.luckclient.service.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckclient.service.dto.UserRegisterCmd;
import com.yuan.luckclient.service.dto.UserUpdateCmd;
import com.yuan.luckclient.service.dto.data.UserVO;
import com.yuan.luckclient.service.dto.query.UserListByParamQuery;
import com.yuan.luckclient.service.dto.query.UserLoginQuery;


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
     *
     * @param query
     * @return
     */
    String login(UserLoginQuery query);
    
    /**
     * 分页查询
     * @param query
     * @return
     */
    IPage<UserVO> page(UserListByParamQuery query);
    
   
    UserVO one(Long userId);
    
    UserVO update(UserUpdateCmd cmd);
    

}
