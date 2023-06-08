package com.yuan.luckapp.activity.command;

import com.yuan.luckdomain.gateway.AwardGateway;
import com.yuan.luckdomain.gateway.PrizeGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Ykj
 * @date 2023/6/8/15:29
 * @apiNote
 */
@Slf4j
@Component
public class RedisDedutionAwardNumberDrawExe extends DefaultDrawExe{
  private final RedisTemplate<String,Object> redisTemplate;
  public RedisDedutionAwardNumberDrawExe(AwardGateway awardGateway, PrizeGateway prizeGateway, RedisTemplate<String, Object> redisTemplate) {
    
    
    super(awardGateway, prizeGateway);
    this.redisTemplate = redisTemplate;
  }
}
