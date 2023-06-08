package com.yuan.luckdomain.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckclient.service.dto.query.RecordListByParamQuery;
import com.yuan.luckdomain.record.RecordEntity;

/**
 * @author Ykj
 * @date 2023/5/26/11:54
 * @apiNote
 */


public interface RecordGateway {
   IPage<RecordEntity> page(RecordListByParamQuery query);
   
   RecordEntity save(RecordEntity addEntity);
}
