package com.yuan.luckinfrastrusture.gateway.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.luckclient.service.dto.query.RecordListByParamQuery;
import com.yuan.luckdomain.gateway.RecordGateway;
import com.yuan.luckdomain.record.RecordEntity;
import com.yuan.luckinfrastrusture.convertor.PrizeConvertor;
import com.yuan.luckinfrastrusture.gateway.impl.dataobject.PrizeDB;
import com.yuan.luckinfrastrusture.gateway.impl.dataobject.RecordDB;
import com.yuan.luckinfrastrusture.gateway.impl.mapper.RecordMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Ykj
 * @date 2023/5/29/14:11
 * @apiNote
 */

@Slf4j
@Component
@AllArgsConstructor
public class RecordGatewayImpl implements RecordGateway {
   
   private final RecordMapper recordMapper;
   @Override
   public IPage<RecordEntity> page(RecordListByParamQuery query) {
      IPage<PrizeDB> page = recordMapper.page(new Page<RecordDB>(query.getPageIndex(), query.getPageSize()), query);
      return page.convert(RecordConvertor::toPrizeEntity);
   }
   
   @Override
   public RecordEntity save(RecordEntity addEntity) {
      return null;
   }
}
