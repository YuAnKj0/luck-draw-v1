package com.yuan.luckinfrastrusture.convertor;

import com.yuan.base.config.utils.SecurityUtil;
import com.yuan.luckdomain.award.AwardEntity;
import com.yuan.luckdomain.award.AwardNumber;
import com.yuan.luckinfrastrusture.gateway.impl.dataobject.AwardDB;

import java.time.LocalDateTime;

/**
 * @author Ykj
 * @date 2023/4/11/18:17
 * @apiNote
 */
public class AwardConvertor {
   
   public static AwardDB toAwardDB(AwardEntity entity) {
       AwardDB awardDB = new AwardDB();
       awardDB.setId(entity.getId());
       awardDB.setPrizeId(entity.getPrizeId());
       awardDB.setActivityId(entity.getActivityId());
       awardDB.setNumber(entity.getNumber().getNumber());
       awardDB.setAwardName(entity.getAwardName());
       awardDB.setProbability(entity.getProbability());
       awardDB.setCreateTime(entity.getCreateTime());
       awardDB.setCreator(entity.getCreator());
       awardDB.setUpdateTime(entity.getUpdateTime());
       awardDB.setUpdater(entity.getUpdater());
       return awardDB;
   }
   
   public static AwardEntity toAwardEntity(AwardDB awardDB) {
       AwardEntity awardEntity = new AwardEntity();
       awardEntity.setId(awardDB.getId());
       awardEntity.setPrizeId(awardDB.getPrizeId());
       awardEntity.setActivityId(awardDB.getActivityId());
       awardEntity.setNumber(new AwardNumber(awardDB.getNumber()));
       awardEntity.setAwardName(awardDB.getAwardName());
       awardEntity.setProbability(awardDB.getProbability());
       awardEntity.setCreateTime(awardDB.getCreateTime());
       awardEntity.setCreator(awardDB.getCreator());
       awardEntity.setUpdateTime(awardDB.getUpdateTime());
       awardEntity.setUpdater(awardDB.getUpdater());
       return awardEntity;
   }
}
