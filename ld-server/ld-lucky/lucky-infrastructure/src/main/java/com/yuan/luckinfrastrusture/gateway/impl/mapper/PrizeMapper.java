package com.yuan.luckinfrastrusture.gateway.impl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.luckclient.service.dto.query.PrizeListByParamQuery;
import com.yuan.luckinfrastrusture.gateway.impl.dataobject.PrizeDB;
import org.apache.ibatis.annotations.Param;

/**
 * @author Ykj
 * @date 2023/4/11/10:20
 * @apiNote
 */
public interface PrizeMapper extends BaseMapper<PrizeDB> {
   IPage<PrizeDB> page(@Param("page") Page<PrizeDB> prizeDBPage,@Param("query") PrizeListByParamQuery query);
    
    int deductionInventory(@Param("prizeId") Long prizeId, @Param("number") Integer number);
}
