package com.yuan.luckdomain.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckclient.service.dto.query.RuleListByParamQuery;
import com.yuan.luckdomain.rule.RuleEntity;

/**
 * @author Ykj
 * @date 2023/4/11/11:42
 * @apiNote
 */
public interface RuleGateway {
   
   RuleEntity save(RuleEntity entity);
   IPage<RuleEntity> page(RuleListByParamQuery query);
   
}
