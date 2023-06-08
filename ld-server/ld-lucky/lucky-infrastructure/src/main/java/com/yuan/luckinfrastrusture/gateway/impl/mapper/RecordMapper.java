package com.yuan.luckinfrastrusture.gateway.impl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.luckclient.service.dto.query.RecordListByParamQuery;
import com.yuan.luckinfrastrusture.gateway.impl.dataobject.PrizeDB;
import com.yuan.luckinfrastrusture.gateway.impl.dataobject.RecordDB;
import org.apache.ibatis.annotations.Param;

/**
* @author Ykj
* @description 针对表【ldb_record】的数据库操作Mapper
* @createDate 2023-03-20 15:21:29
* @Entity com.yuan.user.po.Record
*/
public interface RecordMapper extends BaseMapper<RecordDB> {
    
    IPage<PrizeDB> page(@Param("page") Page<RecordDB> recordDBPage, @Param("query") RecordListByParamQuery query);
}




