package com.yuan.luckinfrastrusture.gateway.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.base.config.enums.LDExceptionEnum;
import com.yuan.base.config.exception.LDException;
import com.yuan.base.config.utils.AssertUtil;
import com.yuan.luckclient.service.dto.query.ActivityListByParamQuery;
import com.yuan.luckdomain.activity.ActivityEntity;
import com.yuan.luckdomain.gateway.ActivityGateway;
import com.yuan.luckinfrastrusture.convertor.ActivityConvertor;
import com.yuan.luckinfrastrusture.gateway.impl.dataobject.ActivityDB;
import com.yuan.luckinfrastrusture.gateway.impl.mapper.ActivityMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author Ykj
 * @date 2023/4/23/10:03
 * @apiNote
 */

@Slf4j
@Component
@AllArgsConstructor
public class ActivityGatewayImpl implements ActivityGateway {
   private final ActivityMapper activityMapper;
   @Override
   public ActivityEntity save(ActivityEntity entity) {
      if (Objects.isNull(entity.getId())){
         return addActivity(entity);
      }
      return updateActivity(entity);
      
   }
   
   private ActivityEntity updateActivity(ActivityEntity entity) {
      ActivityDB activityDB= ActivityConvertor.toActivityDB(entity);
      AssertUtil.isTrue(activityMapper.updateById(activityDB)<=0, LDExceptionEnum.UPDATE_ERROR.getDescription());
      return ActivityConvertor.toEntity(activityDB);
      
   }
   
   private ActivityEntity addActivity(ActivityEntity entity) {
      ActivityDB activityDB= ActivityConvertor.toActivityDB(entity);
      AssertUtil.isTrue(activityMapper.insert(activityDB)<=0,LDExceptionEnum.ADD_ERROR.getDescription());
      return ActivityConvertor.toEntity(activityDB);
      
   }
   
   @Override
   public IPage<ActivityEntity> page(ActivityListByParamQuery query) {
     IPage<ActivityDB> queryPage =  activityMapper.page(new Page<ActivityDB>(query.getPageIndex(),query.getPageSize()),query);
     
      return queryPage.convert(ActivityConvertor::toEntity);
   }
}
