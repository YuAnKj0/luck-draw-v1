package com.yuan.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.user.po.Activity;
import com.yuan.user.service.ActivityService;
import com.yuan.user.mapper.ActivityMapper;
import org.springframework.stereotype.Service;

/**
* @author Ykj
* @description 针对表【ldb_activity】的数据库操作Service实现
* @createDate 2023-03-20 15:21:55
*/
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity>
    implements ActivityService{

}




