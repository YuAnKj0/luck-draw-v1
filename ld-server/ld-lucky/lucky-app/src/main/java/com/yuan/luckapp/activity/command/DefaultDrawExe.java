package com.yuan.luckapp.activity.command;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.WeightRandom;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.base.config.enums.RecordStatusEnum;
import com.yuan.base.config.exception.LDException;
import com.yuan.base.config.utils.AssertUtil;
import com.yuan.base.config.utils.SecurityUtil;
import com.yuan.luckapp.ActivityDrawContext;
import com.yuan.luckapp.assembler.AwardAssembler;
import com.yuan.luckapp.assembler.RecordAssembler;
import com.yuan.luckclient.service.dto.RecordAddCmd;
import com.yuan.luckclient.service.dto.data.*;
import com.yuan.luckclient.service.dto.query.RecordListByParamQuery;
import com.yuan.luckdomain.activity.ActivityEntity;
import com.yuan.luckdomain.activity.ActivityStatusEnum;
import com.yuan.luckdomain.activity.ActivityTime;
import com.yuan.luckdomain.award.AwardEntity;
import com.yuan.luckdomain.gateway.AwardGateway;
import com.yuan.luckdomain.gateway.PrizeGateway;
import com.yuan.luckdomain.gateway.RecordGateway;
import com.yuan.luckdomain.record.RecordEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * @author Ykj
 * @date 2023/6/2/11:39
 * @apiNote
 */
@Slf4j
@Getter
@Component
@AllArgsConstructor
public class DefaultDrawExe extends BaseDrawExe {
    private final RecordGateway recordGateway;
    private final AwardGateway awardGateway;
    private final PrizeGateway prizeGateway;
    
    private final TransactionTemplate transactionTemplate;
    
    
    @Override
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
        if (!awardEntity.isPrize()) {
            return getDrawResultVO(awardEntity);
        }
        // 扣减奖项库存
        if (deductionAwardNumber(awardEntity.getId(), 1) != 1) {
            return getDefaultDrawResultVO(awardVOList);
        }
        // 插入获奖记录
        addAcceptPrize(activityConfigVO.getActivityVO().getId(), awardEntity);
        // 返回抽奖结果
        return getDrawResultVO(awardEntity);
    }
    
    @Override
    protected void addAcceptPrize(Long id, AwardEntity awardEntity) {
        
        
        //TODO
    }
    
    @Override
    protected int deductionAwardNumber(Long awardId, Integer number) {
        //TODO redis优化
        
        return awardGateway.deductionAwardNumber(awardId, number);
    }
    
    @Override
    protected Boolean drawBefore(ActivityDrawContext context) {
        return transactionTemplate.execute(status -> {
            Boolean success = Boolean.TRUE;
            int update = 0;
            try {
                //扣减库存
                update = awardGateway.deductionAwardNumber(context.getAwardVO().getId(), 1);
                AssertUtil.isTrue(update != 1, "扣减库存失败");
                addRecord(context);
            } catch (Exception e) {
                //错误处理
                status.setRollbackOnly();
                if (update > 0) {
                    //回退库存
                    awardGateway.deductionAwardNumber(context.getAwardVO().getId(), -1);
                }
                log.error("扣减库存和插入记录出错", e);
                success = Boolean.FALSE;
            }
            return success;
        });
    }
    
    @Override
    protected void addRecord(ActivityDrawContext context) {
        //插入记录，默认记录可见
        if (Objects.isNull(context.getIsShow())) {
            context.setIsShow(Boolean.TRUE);
        }
        RecordAddCmd recordAddCmd = new RecordAddCmd();
        recordAddCmd.setUserId(SecurityUtil.getUserId());
        recordAddCmd.setActivityId(context.getActivityConfigVO().getActivityVO().getId());
        recordAddCmd.setActivityName(context.getActivityConfigVO().getActivityVO().getActivityName());
        recordAddCmd.setAwardId(context.getAwardVO().getId());
        recordAddCmd.setIsWinning(Boolean.TRUE.equals(context.getAwardEntity().isPrize()) ? 1 : 0);
        recordAddCmd.setState(context.getIsShow() ? RecordStatusEnum.STATUE_1.getValue() : RecordStatusEnum.STATUE_0.getValue());
        
        context.setRecordId(recordGateway.save(RecordAssembler.toAddEntity(recordAddCmd)).getId());
        
    }
    
    
    @Override
    protected DrawResultVO getDrawResultVO(AwardEntity awardEntity) {
        DrawResultVO drawResultVO = new DrawResultVO();
        drawResultVO.setAwardName(awardEntity.getAwardName());
        drawResultVO.setPrizeName(prizeGateway.one(awardEntity.getId()).getPrizeName());
        drawResultVO.setIsDraw(awardEntity.isPrize());
        return drawResultVO;
        
    }
    
    /**
     * 抽奖算法
     * 1.权重
     *
     * @param awardVOList
     * @return
     */
    @Override
    protected AwardVO getAward(List<AwardVO> awardVOList) {
        List<WeightRandom.WeightObj<AwardVO>> weightObjs = new ArrayList<>();
        awardVOList.forEach(item -> weightObjs.add(new WeightRandom.WeightObj<>(item, item.getProbability())));
        //创建带有权重的随机生成器
        WeightRandom<AwardVO> weightRandom = RandomUtil.weightRandom(weightObjs);
        return weightRandom.next();
    }
    
    @Override
    protected List<AwardVO> removeAwardInventoryIsNull(List<AwardVO> awardVOList) {
        if (CollectionUtil.isEmpty(awardVOList)) {
            return new ArrayList<>();
        }
        return awardVOList.stream().filter(item -> item.getNumber() > 0 || "0".equals(item.getPrizeId().toString())).collect(Collectors.toList());
    }
    
    @Override
    protected DrawResultVO addRecordAndGetDrawResultVO(ActivityDrawContext context) {
        return null;
        
    }
    
    @Override
    protected void checkActivityRule(ActivityConfigVO activityConfigVO) {
        List<RuleVO> ruleVOList = activityConfigVO.getRuleVOList();
        if (CollUtil.isEmpty(ruleVOList)) {
            return;
        }
        //获取第一个规则
        RuleVO ruleVO = new RuleVO();
        
        final var query = new RecordListByParamQuery();
        query.setUserId(SecurityUtil.getUserId());
        query.setActivityId(activityConfigVO.getActivityVO().getId());
        query.setPageSize(1000);
        IPage<RecordEntity> page = recordGateway.page(query);
        
        //校验最大参与此时
        AssertUtil.isTrue(page.getRecords().size() >= ruleVO.getMaxJoinNumber(), "你已达到活动最大参与次数，不可参与！");
        
        List<RecordEntity> winningRecords = page.getRecords().stream().filter(item -> item.getIsWining() == 1)
                .collect(Collectors.toList());
        
        //校验最大中奖次数
        AssertUtil.isTrue(winningRecords.size() >= ruleVO.getMaxWiningNumber(), "你已达到最大中奖次数，不可参与！");
    }
    
    @Override
    protected void checkActivityTime(ActivityVO activityVO) {
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setActivityTime(new ActivityTime(activityVO.getStartTime(), activityVO.getEndTime()));
        ActivityStatusEnum status = activityEntity.getActivityTime().getStatus();
        if (!ActivityStatusEnum.START.equals(status)) {
            throw new LDException(String.format("活动s%", status.getDescription()));
        }
    }
}
