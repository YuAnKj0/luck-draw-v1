package com.yuan.luckdomain.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckclient.service.dto.query.ActivityListByParamQuery;
import com.yuan.luckdomain.activity.ActivityEntity;

/**
 * @author Ykj
 * @date 2023/4/21/17:28
 * @apiNote
 */
public interface ActivityGateway {
   ActivityEntity save(ActivityEntity addEntity);
   
   IPage<ActivityEntity> page(ActivityListByParamQuery query);
}
