package com.yuan.luckapp.service;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.base.config.utils.AssertUtil;
import com.yuan.luckapp.activity.command.ActivityAddCmdExe;
import com.yuan.luckapp.activity.command.ActivityUpdateCmdExe;
import com.yuan.luckapp.activity.query.ActivityListByParamQueryExe;

import com.yuan.luckapp.activityrule.command.ActivityRuleAddCmdExe;
import com.yuan.luckapp.activityrule.command.ActivityRuleDeleteExe;
import com.yuan.luckapp.activityrule.query.ActivityRuleListByParamQueryExe;
import com.yuan.luckapp.assembler.ActivityAssembler;
import com.yuan.luckapp.assembler.AwardAssembler;
import com.yuan.luckapp.award.command.AwardAddCmdExe;
import com.yuan.luckapp.award.command.AwardUpdateCmdExe;
import com.yuan.luckapp.award.query.AwardListByParamQueryExe;
import com.yuan.luckapp.listener.ActivityCreateEvent;
import com.yuan.luckapp.rule.query.RuleListByParamQueryExe;
import com.yuan.luckclient.service.api.IActivityConfigService;
import com.yuan.luckclient.service.dto.*;
import com.yuan.luckclient.service.dto.data.*;
import com.yuan.luckclient.service.dto.query.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ykj
 * @date 2023/4/25/16:37
 * @apiNote
 */

@Slf4j
@Service
@AllArgsConstructor
public class ActivityConfigServiceImpl implements IActivityConfigService {
   private final ActivityAddCmdExe activityAddCmdExe;
   private final ActivityRuleAddCmdExe activityRuleAddCmdExe;
   private final AwardAddCmdExe awardAddCmdExe;
   
   private final ActivityUpdateCmdExe activityUpdateCmdExe;
   private final ActivityRuleDeleteExe activityRuleDeleteExe;
   private final AwardUpdateCmdExe awardUpdateCmdExe;
   
   private final ActivityListByParamQueryExe activityListByParamQueryExe;
   private final RuleListByParamQueryExe ruleListByParamQueryExe;
   private final ActivityRuleListByParamQueryExe activityRuleListByParamQueryExe;
   private final AwardListByParamQueryExe awardListByParamQueryExe;
   
   
   private final ApplicationEventMulticaster applicationEventMulticaster;
   
   @Override
   public ActivityConfigVO add(ActivityConfigAddCmd cmd) {
      /*ActivityVO activityVO = activityAddCmdExe.excute(cmd.getActivityAddCmd());
      List<RuleVO> ruleVOList = addActivityRule(activityVO, cmd.getRuleIdList());
      List<AwardVO> awardVOList = addAward(activityVO, cmd.getAwardAddCmdList());
      ActivityConfigVO activityConfigVO = new ActivityConfigVO();
      activityConfigVO.setActivityVO(activityVO);
      activityConfigVO.setRuleVOList(ruleVOList);
      activityConfigVO.setAwardVOList(awardVOList);
      
      //发起活动创建事件
      applicationEventMulticaster.multicastEvent(new ActivityCreateEvent("", activityConfigVO));
      // 发布一个 MQ 信息
      
      return activityConfigVO;*/
      
      ActivityVO activityVO = activityAddCmdExe.excute(cmd.getActivityAddCmd());
      List<RuleVO> ruleVOList = addActivityRule(activityVO, cmd.getRuleIdList());
      List<AwardVO> awardVOList = addAward(activityVO, cmd.getAwardAddCmdList());
      ActivityConfigVO activityConfigVO = new ActivityConfigVO(activityVO, ruleVOList, awardVOList);
      
      //发起活动创建事件
      applicationEventMulticaster.multicastEvent(new ActivityCreateEvent("", activityConfigVO));
      // 发布一个 MQ 信息
      
      return activityConfigVO;
   }
   
   private List<AwardVO> addAward(ActivityVO activityVO, List<AwardAddCmd> awardAddCmdList) {
      AssertUtil.isTrue(CollectionUtil.isEmpty(awardAddCmdList), "奖项不为空！");
      List<AwardVO> result = new ArrayList<>();
      for (AwardAddCmd awardAddCmd : awardAddCmdList) {
         awardAddCmd.setActivityId(activityVO.getId());
         result.add(awardAddCmdExe.excute(awardAddCmd));
      }
      return result;
      
   }
   
   private List<RuleVO> addActivityRule(ActivityVO activityVO, List<Long> ruleIdList) {
      /*List<ActivityRuleAddCmd> cmdList = new ArrayList<>();
      for (Long ruleId : ruleIdList) {
         ActivityRuleAddCmd activityRuleAddCmd = new ActivityRuleAddCmd();
         activityRuleAddCmd.setActivityId(activityVO.getId());
         activityRuleAddCmd.setRuleId(ruleId);
         cmdList.add(activityRuleAddCmd);
      }*/
      
      List<ActivityRuleAddCmd> cmdList = ruleIdList.stream()
              .map(ruleId -> {
                 ActivityRuleAddCmd activityRuleAddCmd = new ActivityRuleAddCmd();
                 activityRuleAddCmd.setActivityId(activityVO.getId());
                 activityRuleAddCmd.setRuleId(ruleId);
                 return activityRuleAddCmd;
              })
              .collect(Collectors.toList());
      List<ActivityRuleVO> activityRuleVOList = activityRuleAddCmdExe.execute(cmdList);
      return getRuleVOList(activityRuleVOList.stream().map(ActivityRuleVO::getRuleId).collect(Collectors.toList()));
   }
   
   private List<RuleVO> getRuleVOList(List<Long> ruleIdList) {
      RuleListByParamQuery query = new RuleListByParamQuery();
      query.setIds(ruleIdList);
      query.setPageSize(1000);
      return ruleListByParamQueryExe.excute(query).getRecords();
   }
   
   @Transactional(rollbackFor = Exception.class)
   @Override
   public ActivityConfigVO update(ActivityConfigUpdateCmd configUpdateCmd) {
      ActivityVO activityVO = activityUpdateCmdExe.excute(configUpdateCmd.getActivityUpdateCmd());
      
      activityRuleDeleteExe.execute(activityVO.getId());
      List<RuleVO> ruleVOList = addActivityRule(activityVO, configUpdateCmd.getRuleIdList());
      List<AwardVO> awardVOList = updateAward(activityVO, configUpdateCmd.getAwardUpdateCmdList());
      
      /*ActivityConfigVO activityConfigVO = new ActivityConfigVO();
      activityConfigVO.setActivityVO(activityVO);
      activityConfigVO.setRuleVOList(ruleVOList);
      activityConfigVO.setAwardVOList(awardVOList);*/
      
      return new ActivityConfigVO(activityVO, ruleVOList, awardVOList);
   }
      
   
   
   private List<AwardVO> updateAward(ActivityVO activityVO, List<AwardUpdateCmd> awardUpdateCmdList) {
      AssertUtil.isTrue(CollectionUtil.isEmpty(awardUpdateCmdList), "奖项不为空！");
      /*List<AwardVO> result = new ArrayList<>();
      for (AwardUpdateCmd awardUpdateCmd : awardUpdateCmdList) {
         result.add(awardUpdateCmdExe.excute(awardUpdateCmd));
      }*/
      return awardUpdateCmdList.stream()
              .map(awardUpdateCmd -> awardUpdateCmdExe.excute(awardUpdateCmd))
              .collect(Collectors.toList());
      
   }
   
   @Override
   public ActivityConfigVO one(Long id) {
      final var activityListByParamQuery = new ActivityListByParamQuery();
      activityListByParamQuery.setId(id);
      List<ActivityVO> activityVOList = activityListByParamQueryExe.page(activityListByParamQuery).getRecords();
      AssertUtil.isTrue(CollectionUtil.isEmpty(activityVOList), "数据不存在！");
      
      ActivityVO activityVO=activityVOList.get(0);
      
      final var activityRuleListByParamQuery = new ActivityRuleListByParamQuery();
      activityRuleListByParamQuery.setActivityId(activityVO.getId());
      List<ActivityRuleVO> activityRuleVOList = activityRuleListByParamQueryExe.execute(activityRuleListByParamQuery);
      List<RuleVO> ruleVOList = getRuleVOList(activityRuleVOList.stream().map(ActivityRuleVO::getRuleId).collect(Collectors.toList()));
      
      AwardListByParamQuery awardListByParamQuery = new AwardListByParamQuery();
      awardListByParamQuery.setActivityId(activityVO.getId());
      awardListByParamQuery.setPageSize(1000);
      List<AwardVO> awardVOList = awardListByParamQueryExe.execute(awardListByParamQuery).getRecords();
      
      /*ActivityConfigVO activityConfigVO = new ActivityConfigVO();
      activityConfigVO.setActivityVO(activityVO);
      activityConfigVO.setAwardVOList(awardVOList);
      activityConfigVO.setRuleVOList(ruleVOList);*/
      
      
      return new ActivityConfigVO(activityVO, ruleVOList, awardVOList);
      
      
   }
   
   @Override
   public ActivityConfigCopyVO copy(Long id) {
      ActivityConfigCopyVO activityConfigCopyVO = new ActivityConfigCopyVO();
      
      ActivityConfigVO activityConfigVO = one(id);
      activityConfigCopyVO.setActivityAddCmd(ActivityAssembler.toActivityAddCmd( activityConfigVO.getActivityVO()));
      activityConfigCopyVO.setRuleIdList(activityConfigVO.getRuleVOList().stream().map(RuleVO::getId).collect(Collectors.toList()));
      activityConfigCopyVO.setAwardAddCmdList(
              new Page<AwardVO>().setRecords(activityConfigVO.getAwardVOList()).convert(AwardAssembler::toAwardAddCmd).getRecords()
      );
      
      return activityConfigCopyVO;
      
   }
}