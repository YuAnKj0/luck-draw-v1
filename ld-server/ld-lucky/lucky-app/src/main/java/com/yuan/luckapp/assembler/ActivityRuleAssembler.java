package com.yuan.luckapp.assembler;

import com.yuan.base.config.utils.SecurityUtil;
import com.yuan.luckclient.service.dto.ActivityRuleAddCmd;
import com.yuan.luckclient.service.dto.data.ActivityRuleVO;
import com.yuan.luckdomain.activityrule.ActivityRuleEntity;

import java.time.LocalDateTime;

/**
 * @author Ykj
 * @date 2023/5/17/9:40
 * @apiNote
 */


public class ActivityRuleAssembler {
   public static ActivityRuleEntity toAddEntity(ActivityRuleAddCmd cmd) {
      ActivityRuleEntity activityRuleEntity = new ActivityRuleEntity();
      activityRuleEntity.setActivityId(cmd.getActivityId());
      activityRuleEntity.setRuleId(cmd.getRuleId());
      activityRuleEntity.setCreateTime(LocalDateTime.now());
      activityRuleEntity.setCreator(SecurityUtil.getName());
      activityRuleEntity.setUpdateTime(LocalDateTime.now());
      activityRuleEntity.setUpdater(SecurityUtil.getName());
      
      return activityRuleEntity;
   }
   
   public static ActivityRuleVO toActivityRuleVO(ActivityRuleEntity entity) {
      ActivityRuleVO activityRuleVO = new ActivityRuleVO();
      activityRuleVO.setId(entity.getId());
      activityRuleVO.setActivityId(entity.getActivityId());
      activityRuleVO.setRuleId(entity.getRuleId());
      activityRuleVO.setCreateTime(entity.getCreateTime());
      activityRuleVO.setCreator(entity.getCreator());
      activityRuleVO.setUpdateTime(entity.getUpdateTime());
      activityRuleVO.setUpdater(entity.getUpdater());
      
      return activityRuleVO;
   }
}
