package com.yuan.luckdomain.gateway;

import com.yuan.luckclient.service.dto.query.ActivityRuleListByParamQuery;
import com.yuan.luckdomain.activityrule.ActivityRuleEntity;

import java.util.List;

/**
 * @author Ykj
 * @date 2023/5/17/9:37
 * @apiNote
 */


public interface ActivityRuleGateway {
   ActivityRuleEntity save(ActivityRuleEntity entity);
   
   List<ActivityRuleEntity> list(ActivityRuleListByParamQuery query);
   
   void deleteByActivityId(Long activityId);
}
