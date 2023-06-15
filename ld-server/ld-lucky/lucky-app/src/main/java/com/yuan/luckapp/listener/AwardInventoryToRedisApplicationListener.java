package com.yuan.luckapp.listener;

import com.yuan.luckapp.assembler.AwardAssembler;
import com.yuan.luckapp.listener.event.ActivityCreateEvent;
import com.yuan.luckclient.service.dto.data.ActivityConfigVO;
import com.yuan.luckclient.service.dto.data.AwardVO;
import com.yuan.luckdomain.award.AwardEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Ykj
 * @date 2023/6/8/11:41
 * @apiNote
 */
@Slf4j
@Component
@AllArgsConstructor
public abstract class AwardInventoryToRedisApplicationListener implements ApplicationListener<ActivityCreateEvent> {
  
  private final RedisTemplate<String,Object> redisTemplate;
  private final static String awardInventoryKey="luck-draw:activity:award:";
  
  
  @Override
    public void onApplicationEvent(ActivityCreateEvent event){
    ActivityConfigVO activityConfigVO=event.getActivityConfig();
    for (AwardVO awardVO : activityConfigVO.getAwardVOList()) {
      AwardEntity awardEntity = AwardAssembler.toAwardEntity(awardVO);
      if (Boolean.FALSE.equals(awardEntity.isPrize())) {
        continue;
      }
      
      redisTemplate.opsForValue().set(getKey(activityConfigVO.getActivityVO().getId(), awardVO.getId()), awardVO
              .getNumber());
    }
    
  }
  
  public static String getKey(Long activityId, Long awardId) {
    return awardInventoryKey + activityId + ":" + activityId;
  }
}
