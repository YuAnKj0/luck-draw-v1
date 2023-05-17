package com.yuan.luckapp.assembler;

import com.yuan.base.config.utils.SecurityUtil;
import com.yuan.luckclient.service.dto.AwardAddCmd;
import com.yuan.luckclient.service.dto.AwardUpdateCmd;
import com.yuan.luckclient.service.dto.data.AwardVO;
import com.yuan.luckdomain.award.AwardEntity;
import com.yuan.luckdomain.award.AwardNumber;

import java.time.LocalDateTime;

/**
 * @author Ykj
 * @date 2023/4/11/17:52
 * @apiNote
 */
public class AwardAssembler {
   public static AwardEntity toAddEntity(AwardAddCmd cmd) {
       AwardEntity awardEntity = new AwardEntity();
       awardEntity.setPrizeId(cmd.getPrizeId());
       awardEntity.setActivityId(cmd.getActivityId());
       awardEntity.setNumber(new AwardNumber(cmd.getNumber()));
       awardEntity.setAwardName(cmd.getAwardName());
       awardEntity.setProbability(cmd.getProbability());
       awardEntity.setCreateTime(LocalDateTime.now());
       awardEntity.setCreator(SecurityUtil.getUserName());
       awardEntity.setUpdateTime(LocalDateTime.now());
       awardEntity.setUpdater(SecurityUtil.getUserName());
       return awardEntity;
      
   }
   
   public static AwardVO toAwardVO(AwardEntity entity) {
       AwardVO awardVO = new AwardVO();
       awardVO.setId(entity.getId());
       awardVO.setPrizeId(entity.getPrizeId());
       awardVO.setActivityId(entity.getActivityId());
       awardVO.setNumber(entity.getNumber().getNumber());
       awardVO.setAwardName(entity.getAwardName());
       awardVO.setProbability(entity.getProbability());
       awardVO.setCreateTime(entity.getCreateTime());
       awardVO.setCreator(entity.getCreator());
       awardVO.setUpdateTime(entity.getUpdateTime());
       awardVO.setUpdater(entity.getUpdater());
       return awardVO;
   }
    
    public static AwardEntity toUpdateEntity(AwardUpdateCmd cmd) {
        AwardEntity awardEntity = new AwardEntity();
        awardEntity.setId(cmd.getId());
        awardEntity.setPrizeId(cmd.getPrizeId());
        awardEntity.setActivityId(cmd.getActivityId());
        awardEntity.setNumber(new AwardNumber(cmd.getNumber()));
        awardEntity.setAwardName(cmd.getAwardName());
        awardEntity.setProbability(cmd.getProbability());
        awardEntity.setUpdateTime(LocalDateTime.now());
        awardEntity.setUpdater(SecurityUtil.getUserName());
        return awardEntity;
    }
    
    public static AwardAddCmd toAwardAddCmd(AwardVO awardVO) {
        AwardAddCmd awardAddCmd = new AwardAddCmd();
        awardAddCmd.setPrizeId(awardVO.getPrizeId());
        awardAddCmd.setNumber(awardVO.getNumber());
        awardAddCmd.setAwardName(awardVO.getAwardName());
        awardAddCmd.setProbability(awardVO.getProbability());
        
        return awardAddCmd;
    }
    
    public static AwardEntity toAwardEntity(AwardVO awardVO) {
        AwardEntity awardEntity = new AwardEntity();
        awardEntity.setId(awardVO.getId());
        awardEntity.setPrizeId(awardVO.getPrizeId());
        awardEntity.setActivityId(awardVO.getActivityId());
        awardEntity.setNumber(new AwardNumber(awardVO.getNumber()));
        awardEntity.setAwardName(awardVO.getAwardName());
        awardEntity.setProbability(awardVO.getProbability());
        awardEntity.setCreateTime(awardVO.getCreateTime());
        awardEntity.setCreator(awardVO.getCreator());
        awardEntity.setUpdateTime(awardVO.getUpdateTime());
        awardEntity.setUpdater(awardVO.getUpdater());
        
        return awardEntity;
    }
}
