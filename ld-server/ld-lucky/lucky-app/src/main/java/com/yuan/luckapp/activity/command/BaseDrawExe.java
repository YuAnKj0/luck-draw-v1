package com.yuan.luckapp.activity.command;

import com.yuan.luckapp.ActivityDrawContext;
import com.yuan.luckapp.assembler.AwardAssembler;
import com.yuan.luckclient.service.dto.data.ActivityConfigVO;
import com.yuan.luckclient.service.dto.data.ActivityVO;
import com.yuan.luckclient.service.dto.data.AwardVO;
import com.yuan.luckclient.service.dto.data.DrawResultVO;
import com.yuan.luckdomain.award.AwardEntity;

import java.util.List;

/**
 * @author Ykj
 * @date 2023/6/4/18:29
 * @apiNote
 */

public abstract class BaseDrawExe {
  
  
  
  public DrawResultVO execute(ActivityConfigVO activityConfigVO) {
    
    // 校验活动时间
    checkActivityTime(activityConfigVO.getActivityVO());
    // 校验活动规则
    checkActivityRule(activityConfigVO);
    // 剔除库存为空的奖项
    List<AwardVO> awardVOList = removeAwardInventoryIsNull(activityConfigVO.getAwardVOList());
    // 调用抽奖算法进行抽奖
    AwardVO awardVO = getAward(awardVOList);
    AwardEntity awardEntity = AwardAssembler.toAwardEntity(awardVO);
    if (!awardEntity.isPrize()){
      return getDrawResultVO(awardEntity);
    }
    // 扣减奖项库存
    if (deductionAwardNumber(awardEntity.getId(),1)!=1){
      return getDefaultDrawResultVO( awardVOList);
    }
    // 插入获奖记录
    addAcceptPrize(activityConfigVO.getActivityVO().getId(),awardEntity);
    // 返回抽奖结果
    return getDrawResultVO(awardEntity);
  }
  
  protected abstract void checkActivityRule(ActivityConfigVO activityConfigVO);
  
  protected abstract int deductionAwardNumber(Long id, Integer i);
  
  DrawResultVO getDefaultDrawResultVO(List<AwardVO> awardVOList){
    DrawResultVO drawResultVO = new DrawResultVO();
    for (AwardVO awardVO: awardVOList) {
      if ("0".equals(awardVO.getPrizeId())){
        drawResultVO = getDrawResultVO(AwardAssembler.toAwardEntity(awardVO));
        break;
      }
    }
    return drawResultVO;
    
  }
  
  protected abstract void addAcceptPrize(Long id, AwardEntity awardEntity);
  
  protected abstract Boolean drawBefore(ActivityDrawContext context);
  
  protected abstract DrawResultVO getDrawResultVO(AwardEntity awardEntity);
  
  protected abstract AwardVO getAward(List<AwardVO> awardVOList);
  
  protected abstract List<AwardVO> removeAwardInventoryIsNull(List<AwardVO> awardVOList);
  
  protected abstract void checkActivityTime(ActivityVO activityVO);
}
