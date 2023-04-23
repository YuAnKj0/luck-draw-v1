package com.yuan.luckinfrastrusture.gateway.impl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.luckclient.service.dto.query.ActivityListByParamQuery;
import com.yuan.luckinfrastrusture.gateway.impl.dataobject.ActivityDB;
import org.apache.ibatis.annotations.Param;

/**
* @author Ykj
* @description 针对表【ldb_activity】的数据库操作Mapper
* @createDate 2023-03-20 15:21:55
* @Entity com.yuan.user.po.Activity
*/
public interface ActivityMapper extends BaseMapper<ActivityDB> {
    
    IPage<ActivityDB> page(@Param("activityDBPage") Page<ActivityDB> activityDBPage, @Param("query") ActivityListByParamQuery query);
}




