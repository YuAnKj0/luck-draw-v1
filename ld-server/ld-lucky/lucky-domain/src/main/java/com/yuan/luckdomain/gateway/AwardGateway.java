package com.yuan.luckdomain.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckclient.service.dto.query.AwardListByParamQuery;
import com.yuan.luckdomain.award.AwardEntity;

/**
 * @author Ykj
 * @date 2023/4/11/17:50
 * @apiNote
 */
public interface AwardGateway {
   AwardEntity save(AwardEntity entity);
   
   IPage<AwardEntity> page(AwardListByParamQuery query);
    
    AwardEntity one(Long id);
    
    int deductionAwardNumber(Long awardId, int number);
}
