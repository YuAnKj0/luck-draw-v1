package com.yuan.luckapp.activity.command;

import com.yuan.base.config.exception.LDException;
import com.yuan.base.config.utils.FileLoad;
import com.yuan.luckapp.ActivityDrawContext;
import com.yuan.luckapp.listener.AwardInventoryToRedisApplicationListener;
import com.yuan.luckapp.mq.producer.ActivityDrawMessageProducer;
import com.yuan.luckdomain.gateway.AwardGateway;
import com.yuan.luckdomain.gateway.PrizeGateway;
import com.yuan.luckdomain.gateway.RecordGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Objects;

/**
 * @author Ykj
 * @date 2023/6/8/15:29
 * @apiNote
 */
@Slf4j
@Component
public class RedisDeductionAwardNumberDrawExe extends DefaultDrawExe {
  private final RedisTemplate<String, Object> redisTemplate;
  private final ActivityDrawMessageProducer activityDrawMessageProducer;
  
  
  private static String stockDeductionLua;
  private static String stockRollbackLua;
  
  static {
    RedisDeductionAwardNumberDrawExe.stockDeductionLua = FileLoad.read("lua/stock_deduction.lua");
    RedisDeductionAwardNumberDrawExe.stockRollbackLua = FileLoad.read("lua/stock_rollback.lua");
  }
  
  public RedisDeductionAwardNumberDrawExe(RecordGateway recordGateway,
                                          AwardGateway awardGateway,
                                          PrizeGateway prizeGateway,
                                          TransactionTemplate transactionTemplate,
                                          ActivityDrawMessageProducer activityDrawMessageProducer,
                                          RedisTemplate<String, Object> redisTemplate) {
    super(recordGateway, awardGateway, prizeGateway, transactionTemplate);
    this.redisTemplate = redisTemplate;
    this.activityDrawMessageProducer = activityDrawMessageProducer;
  }
  
  @Override
  protected Boolean drawBefore(ActivityDrawContext context) {
    //扣减redis库存
    Integer dedutionLua = invokeStockDeductionLua(AwardInventoryToRedisApplicationListener.getKey(context.getAwardEntity().getActivityId(), context.getAwardVO().getId()));
    if (dedutionLua != 1) {
      return Boolean.FALSE;
    }
    return super.getTransactionTemplate().execute(status -> {
      Boolean success = Boolean.TRUE;
      try {
        //插入不可见抽奖记录
        context.setIsShow(Boolean.FALSE);
        super.addRecord(context);
        //发送MQ消息
        if (Boolean.FALSE.equals(activityDrawMessageProducer.send(context))) {
          throw new LDException("MQ消息发送失败");
        }
      } catch (Exception e) {
        //错误处理
        status.setRollbackOnly();
        invokeStockRollbackLua(AwardInventoryToRedisApplicationListener.getKey(context.getAwardEntity().getActivityId(), context.getAwardVO().getId()));
        success = Boolean.FALSE;
        log.error("扣减库存失败或发送MQ消息失败，", e);
      }
      return success;
    });
    
  }
  
  private Integer invokeStockRollbackLua(String key) {
    RedisScript<Long> redisScript = new DefaultRedisScript<>(stockRollbackLua, Long.class);
    Long execute = redisTemplate.opsForValue().getOperations().execute(redisScript, List.of(key));
    if (Objects.isNull(execute) || execute == -1) {
      return 0;
    }
    return 1;
  }
  
  
  private Integer invokeStockDeductionLua(String key) {
    RedisScript<Long> redisScript = new DefaultRedisScript<>(stockDeductionLua, Long.class);
    Long execute = redisTemplate.opsForValue().getOperations().execute(redisScript, List.of(key));
    if (Objects.isNull(execute) || execute == -1) {
      return 0;
    }
    return 1;
  }
  
}
