package com.yuan.luckapp.activity.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckapp.assembler.ActivityAssembler;
import com.yuan.luckapp.assembler.AwardAssembler;
import com.yuan.luckclient.service.dto.data.ActivityVO;
import com.yuan.luckclient.service.dto.data.AwardVO;
import com.yuan.luckclient.service.dto.query.ActivityListByParamQuery;
import com.yuan.luckclient.service.dto.query.AwardListByParamQuery;
import com.yuan.luckdomain.activity.ActivityEntity;
import com.yuan.luckdomain.award.AwardEntity;
import com.yuan.luckdomain.gateway.ActivityGateway;
import com.yuan.luckdomain.gateway.AwardGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@AllArgsConstructor
/**
 * @author Ykj
 * @date 2023/4/21/17:21
 * @apiNote
 */
public class ActivityListByParamQueryExe {
   private final ActivityGateway gateway;
   public IPage<ActivityVO> page(ActivityListByParamQuery query) {
      IPage<ActivityEntity> queryPage = gateway.page(query);
      return queryPage.convert(ActivityAssembler::toActivityVO);
   }
}
