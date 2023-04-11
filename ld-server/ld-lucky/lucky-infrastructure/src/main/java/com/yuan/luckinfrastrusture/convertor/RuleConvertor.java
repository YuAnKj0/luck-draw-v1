package com.yuan.luckinfrastrusture.convertor;

import com.yuan.luckdomain.rule.MinNumber;
import com.yuan.luckdomain.rule.RuleEntity;
import com.yuan.luckinfrastrusture.gateway.impl.dataobject.RuleDB;

/**
 * @author Ykj
 * @date 2023/4/11/14:22
 * @apiNote
 */
public class RuleConvertor {
   
   public static RuleDB toRuleDB(RuleEntity entity) {
       RuleDB ruleDB = new RuleDB();
       ruleDB.setId(entity.getId());
       ruleDB.setRuleName(entity.getRuleName());
       ruleDB.setMaxJoinNumber(entity.getMaxJoinNumber().getNumber());
       ruleDB.setMaxWiningNumber(entity.getMaxWiningNumber().getNumber());
       ruleDB.setCreateTime(entity.getCreateTime());
       ruleDB.setCreator(entity.getCreator());
       ruleDB.setUpdateTime(entity.getUpdateTime());
       ruleDB.setUpdater(entity.getUpdater());
       return ruleDB;
   }
   
   public static RuleEntity toRuleEntity(RuleDB ruleDB) {
       RuleEntity ruleEntity = new RuleEntity();
       ruleEntity.setId(ruleDB.getId());
       ruleEntity.setRuleName(ruleDB.getRuleName());
       ruleEntity.setMaxJoinNumber(new MinNumber(ruleDB.getMaxJoinNumber()));
       ruleEntity.setMaxWiningNumber(new MinNumber(ruleDB.getMaxWiningNumber()));
       ruleEntity.setCreateTime(ruleDB.getCreateTime());
       ruleEntity.setCreator(ruleDB.getCreator());
       ruleEntity.setUpdateTime(ruleDB.getUpdateTime());
       ruleEntity.setUpdater(ruleDB.getUpdater());
       return ruleEntity;
   }
}
