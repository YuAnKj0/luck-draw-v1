package com.yuan.luckinfrastrusture.gateway.impl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.luckclient.service.dto.query.AwardListByParamQuery;
import com.yuan.luckinfrastrusture.gateway.impl.dataobject.AwardDB;
import org.apache.ibatis.annotations.Param;

/**
* @author Ykj
* @description 针对表【ldb_award】的数据库操作Mapper
* @createDate 2023-03-20 15:21:48
* @Entity com.yuan.user.po.Award
*/
public interface AwardMapper extends BaseMapper<AwardDB> {
    
    IPage<AwardDB> page(@Param("awardDBPage") Page<AwardDB> awardDBPage, @Param("query") AwardListByParamQuery query);
}




