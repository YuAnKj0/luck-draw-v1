package com.yuan.luckinfrastrusture.gateway.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckclient.service.dto.query.RuleListByParamQuery;
import com.yuan.luckdomain.gateway.RuleGateway;
import com.yuan.luckdomain.rule.RuleEntity;

/**
 * @author Ykj
 * @date 2023/4/11/12:00
 * @apiNote
 */
public class RuleGatewayImpl implements RuleGateway {
   @Override
   public RuleEntity save(RuleEntity entity) {
      return null;
   }
   
   @Override
   public IPage<RuleEntity> page(RuleListByParamQuery query) {
      return null;
   }
}
