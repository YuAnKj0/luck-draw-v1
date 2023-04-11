package com.yuan.luckdomain.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckclient.service.dto.query.PrizeListByParamQuery;
import com.yuan.luckdomain.prize.PrizeEntity;

/**
 * @author Ykj
 * @date 2023/4/10/16:49
 * @apiNote
 */
public interface PrizeGateway {
    
    PrizeEntity save(PrizeEntity entity);
    IPage<PrizeEntity> page(PrizeListByParamQuery query);
    
}
