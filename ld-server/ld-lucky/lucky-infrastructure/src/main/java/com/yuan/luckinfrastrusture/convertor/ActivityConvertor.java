package com.yuan.luckinfrastrusture.convertor;

import com.yuan.luckdomain.activity.ActivityEntity;
import com.yuan.luckdomain.activity.ActivityTime;
import com.yuan.luckinfrastrusture.gateway.impl.dataobject.ActivityDB;

/**
 * @author Ykj
 * @date 2023/4/23/10:07
 * @apiNote
 */


public class ActivityConvertor {
   public static ActivityDB toActivityDB(ActivityEntity entity) {
       ActivityDB activityDB = new ActivityDB();
       activityDB.setId(entity.getId());
       activityDB.setActivityName(entity.getActivityName());
       activityDB.setStartTime(entity.getActivityTime().getStartTime());
       activityDB.setEndTime(entity.getActivityTime().getEndTime());
       activityDB.setDescribe(entity.getDescribe());
       activityDB.setCreateTime(entity.getCreateTime());
       activityDB.setCreator(entity.getCreator());
       activityDB.setUpdateTime(entity.getUpdateTime());
       activityDB.setUpdater(entity.getUpdater());
       return activityDB;
   }
   
   public static ActivityEntity toEntity(ActivityDB activityDB) {
       ActivityEntity activityEntity = new ActivityEntity();
       activityEntity.setId(activityDB.getId());
       activityEntity.setActivityName(activityDB.getActivityName());
       activityEntity.setActivityTime(new ActivityTime(activityDB.getStartTime(),activityDB.getEndTime()));
       activityEntity.setDescribe(activityDB.getDescribe());
       activityEntity.setCreateTime(activityDB.getCreateTime());
       activityEntity.setCreator(activityDB.getCreator());
       activityEntity.setUpdateTime(activityDB.getUpdateTime());
       activityEntity.setUpdater(activityDB.getUpdater());
       return activityEntity;
   }
}
