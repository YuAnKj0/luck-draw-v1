package com.yuan.luckapp.assembler;

import com.yuan.base.config.utils.SecurityUtil;
import com.yuan.luckclient.service.dto.RecordAddCmd;
import com.yuan.luckclient.service.dto.data.RecordVO;
import com.yuan.luckdomain.record.RecordEntity;
import com.yuan.luckdomain.record.RecordStatus;

import java.time.LocalDateTime;

/**
 * @author Ykj
 * @date 2023/5/26/11:56
 * @apiNote
 */


public class RecordAssembler {
   public static RecordVO toRecordVO(RecordEntity recordEntity) {
       RecordVO recordVO = new RecordVO();
       recordVO.setId(recordEntity.getId());
       recordVO.setUserId(recordEntity.getUserId());
       recordVO.setActivityId(recordEntity.getActivityId());
       recordVO.setActivityName(recordVO.getActivityName());
       recordVO.setAwardId(recordEntity.getAwardId());
       recordVO.setAwardName(recordVO.getAwardName());
       recordVO.setPrizeName(recordVO.getPrizeName());
       recordVO.setPrizeType(recordVO.getPrizeType());
       recordVO.setIsWinning(recordVO.getIsWinning());
       recordVO.setState(recordEntity.getState().getStatus());
       recordVO.setCreateTime(recordEntity.getCreateTime());
       recordVO.setCreator(recordEntity.getCreator());
       recordVO.setUpdateTime(recordEntity.getUpdateTime());
       recordVO.setUpdater(recordEntity.getUpdater());
       return recordVO;
      
   }
    
    public static RecordEntity toAddEntity(RecordAddCmd cmd) {
        RecordEntity recordEntity = new RecordEntity();
        recordEntity.setId(cmd.getId());
        recordEntity.setUserId(cmd.getUserId());
        recordEntity.setActivityId(cmd.getActivityId());
        recordEntity.setAwardId(cmd.getAwardId());
        recordEntity.setIsWining(cmd.getIsWinning());
        recordEntity.setState(new RecordStatus(cmd.getState()));
        recordEntity.setCreateTime(LocalDateTime.now());
        recordEntity.setCreator(SecurityUtil.getUserName());
        recordEntity.setUpdateTime(LocalDateTime.now());
        recordEntity.setUpdater(SecurityUtil.getUserName());
        return recordEntity;
    }
}
