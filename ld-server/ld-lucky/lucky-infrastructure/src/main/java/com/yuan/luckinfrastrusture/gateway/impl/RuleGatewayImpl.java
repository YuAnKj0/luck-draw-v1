package com.yuan.luckinfrastrusture.gateway.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.base.config.enums.LDExceptionEnum;
import com.yuan.base.config.exception.LDException;
import com.yuan.base.config.utils.AssertUtil;
import com.yuan.luckclient.service.dto.query.RuleListByParamQuery;
import com.yuan.luckdomain.gateway.RuleGateway;
import com.yuan.luckdomain.rule.RuleEntity;
import com.yuan.luckinfrastrusture.convertor.RuleConvertor;
import com.yuan.luckinfrastrusture.gateway.impl.dataobject.RuleDB;
import com.yuan.luckinfrastrusture.gateway.impl.mapper.RuleMapper;

import java.util.Objects;

/**
 * @author Ykj
 * @date 2023/4/11/12:00
 * @apiNote
 */
public class RuleGatewayImpl implements RuleGateway {
   private RuleMapper ruleMapper;
   @Override
   public RuleEntity save(RuleEntity entity) {
      if (Objects.isNull(entity.getId())) {
         return addRule(entity);
      }
      return updateRule(entity);
   }
   
   private RuleEntity updateRule(RuleEntity entity) {
      RuleDB ruleDB = RuleConvertor.toRuleDB(entity);
      AssertUtil.isTrue(ruleMapper.updateById(ruleDB)<=0, LDExceptionEnum.UPDATE_ERROR.getDescription());
      return RuleConvertor.toRuleEntity(ruleDB);
   }
   
   private RuleEntity addRule(RuleEntity entity) {
      RuleDB ruleDB = RuleConvertor.toRuleDB(entity);
      AssertUtil.isTrue(ruleMapper.updateById(ruleDB)<=0,LDExceptionEnum.ADD_ERROR.getDescription());
      return RuleConvertor.toRuleEntity(ruleDB);
  
   }
   
   @Override
   public IPage<RuleEntity> page(RuleListByParamQuery query) {
      IPage<RuleDB> page = ruleMapper.page(new Page<RuleDB>(query.getPageIndex(), query.getPageSize()), query);
      return page.convert(RuleConvertor::toRuleEntity);
   }
}
