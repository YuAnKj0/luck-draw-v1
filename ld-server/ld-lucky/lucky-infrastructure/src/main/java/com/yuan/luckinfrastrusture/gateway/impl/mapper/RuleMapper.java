package com.yuan.luckinfrastrusture.gateway.impl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.luckclient.service.dto.query.RuleListByParamQuery;
import com.yuan.luckinfrastrusture.gateway.impl.dataobject.RuleDB;
import org.apache.ibatis.annotations.Param;

/**
* @author Ykj
* @description 针对表【ldb_rule】的数据库操作Mapper
* @createDate 2023-03-20 15:21:20
* @Entity com.yuan.user.po.Rule
*/
public interface RuleMapper extends BaseMapper<RuleDB> {
    
    
    IPage<RuleDB> page(@Param("ruleDBPage") Page<RuleDB> ruleDBPage, @Param("query") RuleListByParamQuery query);
}




