package com.yuan.luck.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.luck.user.po.User;
import com.yuan.luck.user.service.UserService;
import com.yuan.luck.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Ykj
* @description 针对表【ldb_user】的数据库操作Service实现
* @createDate 2023-03-20 15:19:36
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

}




