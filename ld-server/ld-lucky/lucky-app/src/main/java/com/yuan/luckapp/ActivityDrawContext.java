package com.yuan.luckapp;

import com.yuan.luckclient.service.dto.data.ActivityConfigVO;
import com.yuan.luckclient.service.dto.data.AwardVO;
import com.yuan.luckdomain.award.AwardEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Ykj
 * @date 2023/6/8/15:51
 * @apiNote
 */
@Data
@Accessors(chain = true)
public class ActivityDrawContext {
  
  private ActivityConfigVO activityConfigVO;
  /**
   * 抽奖算法获得到的奖项
   */
  private AwardVO awardVO;
  /**
   * 抽奖算法获得到的奖项entity
   */
  private AwardEntity awardEntity;
  /**
   * 是否中奖,true:中奖
   */
  private Boolean isWinTheLottery;
  
  /**
   * 是否可见，用户中奖日志是否可见
   */
  private Boolean isShow;
  /**
   * 中奖记录ID
   */
  private Long recordId;
  
}
