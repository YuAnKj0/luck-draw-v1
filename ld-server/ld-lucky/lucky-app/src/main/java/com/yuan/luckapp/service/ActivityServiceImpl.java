package com.yuan.luckapp.service;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.base.config.utils.SecurityUtil;
import com.yuan.luckapp.activity.command.ActivityAddCmdExe;
import com.yuan.luckapp.activity.command.ActivityUpdateCmdExe;
import com.yuan.luckapp.activity.command.DrawExe;
import com.yuan.luckapp.activity.query.ActivityListByParamQueryExe;
import com.yuan.luckclient.service.api.IActivityConfigService;
import com.yuan.luckclient.service.api.IActivityService;
import com.yuan.luckclient.service.dto.ActivityAddCmd;
import com.yuan.luckclient.service.dto.ActivityUpdateCmd;
import com.yuan.luckclient.service.dto.data.ActivityConfigVO;
import com.yuan.luckclient.service.dto.data.ActivityVO;
import com.yuan.luckclient.service.dto.data.DrawResultVO;
import com.yuan.luckclient.service.dto.query.ActivityListByParamQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Ykj
 * @date 2023/4/21/17:17
 * @apiNote
 */
@Slf4j
@Service
@AllArgsConstructor
public class ActivityServiceImpl implements IActivityService {
   
   private final ActivityListByParamQueryExe activityListByParamQueryExe;
   private final ActivityUpdateCmdExe activityUpdateCmdExe;
   private final ActivityAddCmdExe activityAddCmdExe;
   private final DrawExe drawExe;
   private final IActivityConfigService activityConfigService;
   @Override
   public ActivityVO add(ActivityAddCmd cmd) {
      return activityAddCmdExe.excute(cmd);
   }
   
   @Override
   public ActivityVO update(ActivityUpdateCmd cmd) {
      return activityUpdateCmdExe.excute(cmd);
   }
   
   @Override
   public IPage<ActivityVO> page(ActivityListByParamQuery query) {
      return activityListByParamQueryExe.page(query);
   }
   
   @Override
   public ActivityVO one(Long id) {
      final var query=new ActivityListByParamQuery();
      query.setId(id);
      IPage<ActivityVO> page = page(query);
      if (CollectionUtil.isEmpty(page.getRecords())){
         return null;
      }
      return page.getRecords().get(0);
   }

   @Override
   public DrawResultVO draw(Long activityId) {
      
      log.info("用户：{}开始抽奖。。。", SecurityUtil.getName());
      ActivityConfigVO activityConfigVO = activityConfigService.one(activityId);
      return drawExe.execute(activityConfigVO);
   }
}
