package com.yuan.luckapp.activity.command;

import com.yuan.luckapp.ActivityDrawContext;
import com.yuan.luckapp.assembler.AwardAssembler;
import com.yuan.luckclient.service.dto.data.ActivityConfigVO;
import com.yuan.luckclient.service.dto.data.ActivityVO;
import com.yuan.luckclient.service.dto.data.AwardVO;
import com.yuan.luckclient.service.dto.data.DrawResultVO;
import com.yuan.luckdomain.award.AwardEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author Ykj
 * @date 2023/6/4/18:29
 * @apiNote
 */
@Slf4j
public abstract class BaseDrawExe {
  
  /**
   * 抽奖模板方法，流程不会改动，
   *
   * @param context
   * @return
   */
  public DrawResultVO execute(ActivityDrawContext context) {
    // 校验活动时间
    checkActivityTime(context.getActivityConfigVO().getActivityVO());
    // 校验活动规则
    checkActivityRule(context.getActivityConfigVO());
    // 剔除库存为空的奖项
    List<AwardVO> awardVOList = removeAwardInventoryIsNull(context.getActivityConfigVO().getAwardVOList());
    // 调用抽奖算法进行抽奖
    
    context.setAwardVO(getAward(awardVOList));
    context.setAwardEntity(AwardAssembler.toAwardEntity(context.getAwardVO()));
    context.setIsWinTheLottery(context.getAwardEntity().isPrize());
    
    if (Boolean.FALSE.equals(context.getIsWinTheLottery())) {
      //插入未中奖记录
      return addRecordAndGetDrawResultVO(context);
      // return getDrawResultVO(context.getAwardEntity());
    }
    Boolean drawBefore = drawBefore(context);
    try {
      //调用抽奖后续流程
      drawBefore = drawBefore(context);
    } catch (Exception e) {
      //错误处理
      drawBefore = Boolean.FALSE;
      log.error("执行drawBefore方法出错，默认返回未中奖信息，", e);
    }
    if (Boolean.FALSE.equals(drawBefore)) {
      //执行drawBefore()出错，默认返回未中奖
      context.setAwardVO(getAward(context.getActivityConfigVO().getAwardVOList()));
      context.setAwardEntity(AwardAssembler.toAwardEntity(context.getAwardVO()));
      context.setIsWinTheLottery(Boolean.FALSE);
      return addRecordAndGetDrawResultVO(context);
    }
    /*// 扣减奖项库存
    if (deductionAwardNumber(awardEntity.getId(), 1) != 1) {
      return getDefaultDrawResultVO(awardVOList);
    }
    // 插入获奖记录
    addAcceptPrize(activityConfigVO.getActivityVO().getId(), awardEntity);
    // 返回抽奖结果*/
    return getDrawResultVO(context.getAwardEntity());
  }
  
  protected abstract DrawResultVO addRecordAndGetDrawResultVO(ActivityDrawContext context);
  
  protected abstract void checkActivityRule(ActivityConfigVO activityConfigVO);
  
  protected abstract int deductionAwardNumber(Long id, Integer i);
  
  DrawResultVO getDefaultDrawResultVO(List<AwardVO> awardVOList) {
    DrawResultVO drawResultVO = new DrawResultVO();
    for (AwardVO awardVO : awardVOList) {
      if ("0".equals(awardVO.getPrizeId())) {
        drawResultVO = getDrawResultVO(AwardAssembler.toAwardEntity(awardVO));
        break;
      }
    }
    return drawResultVO;
    
  }
  
  public abstract DrawResultVO execute(ActivityConfigVO activityConfigVO);
  
  protected abstract void addAcceptPrize(Long id, AwardEntity awardEntity);
  
  protected abstract Boolean drawBefore(ActivityDrawContext context);
  
  protected abstract void addRecord(ActivityDrawContext context);
  
  protected abstract DrawResultVO getDrawResultVO(AwardEntity awardEntity);
  
  protected abstract AwardVO getAward(List<AwardVO> awardVOList);
  
  protected abstract List<AwardVO> removeAwardInventoryIsNull(List<AwardVO> awardVOList);
  
  protected abstract void checkActivityTime(ActivityVO activityVO);
}
