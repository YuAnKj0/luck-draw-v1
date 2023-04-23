package com.yuan.luckapp.assembler;

import com.yuan.base.config.utils.SecurityUtil;
import com.yuan.luckclient.service.dto.ActivityAddCmd;
import com.yuan.luckclient.service.dto.ActivityUpdateCmd;
import com.yuan.luckclient.service.dto.data.ActivityVO;
import com.yuan.luckdomain.activity.ActivityEntity;
import com.yuan.luckdomain.activity.ActivityTime;

import java.time.LocalDateTime;

/**
 * @author Ykj
 * @date 2023/4/21/17:29
 * @apiNote
 */
public class ActivityAssembler {
   public static ActivityEntity toAddEntity(ActivityAddCmd cmd) {
       ActivityEntity activityEntity = new ActivityEntity();
       activityEntity.setActivityName(cmd.getActivityName());
       activityEntity.setDescribe(cmd.getDescribe());
       activityEntity.setCreateTime(LocalDateTime.now());
       activityEntity.setCreator(SecurityUtil.getName());
       activityEntity.setUpdateTime(LocalDateTime.now());
       activityEntity.setUpdater(SecurityUtil.getName());
       return activityEntity;
      
   }
   
   public static ActivityVO toActivityVO(ActivityEntity entity) {
       ActivityVO activityVO = new ActivityVO();
       activityVO.setId(entity.getId());
       activityVO.setActivityName(entity.getActivityName());
       activityVO.setStartTime(entity.getActivityTime().getStartTime());
       activityVO.setEndTime(entity.getActivityTime().getEndTime());
       activityVO.setDescribe(entity.getDescribe());
       activityVO.setCreateTime(entity.getCreateTime());
       activityVO.setCreator(entity.getCreator());
       activityVO.setUpdateTime(entity.getUpdateTime());
       activityVO.setUpdater(entity.getUpdater());
       activityVO.setStatus(entity.getActivityTime().getStatus().getValue());
       return activityVO;
       
   }
   
   public static ActivityEntity toUpdateEntity(ActivityUpdateCmd cmd) {
       ActivityEntity activityEntity = new ActivityEntity();
       activityEntity.setId(cmd.getId());
       activityEntity.setActivityName(cmd.getActivityName());
       activityEntity.setDescribe(cmd.getDescribe());
       activityEntity.setUpdateTime(LocalDateTime.now());
       activityEntity.setUpdater(SecurityUtil.getName());
       return activityEntity;
       
   }
}
