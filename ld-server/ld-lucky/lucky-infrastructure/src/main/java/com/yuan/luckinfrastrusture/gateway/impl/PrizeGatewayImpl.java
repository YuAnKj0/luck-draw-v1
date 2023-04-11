package com.yuan.luckinfrastrusture.gateway.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.base.config.exception.LDException;
import com.yuan.luckclient.service.dto.query.PrizeListByParamQuery;
import com.yuan.luckdomain.gateway.PrizeGateway;
import com.yuan.luckdomain.prize.PrizeEntity;
import com.yuan.luckinfrastrusture.convertor.PrizeConvertor;
import com.yuan.luckinfrastrusture.gateway.impl.dataobject.PrizeDB;
import com.yuan.luckinfrastrusture.gateway.impl.mapper.PrizeMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;




/**
 * @author Ykj
 * @date 2023/4/11/10:14
 * @apiNote
 */
@Slf4j
@Component
@AllArgsConstructor
public class PrizeGatewayImpl implements PrizeGateway {
   
   private PrizeMapper prizeMapper;
   @Override
   public PrizeEntity save(PrizeEntity entity) {
      if (Objects.isNull(entity.getId())){
         return addPrize(entity);
      }
      return updateEntity(entity);
   }
   
   private PrizeEntity updateEntity(PrizeEntity entity) {
      PrizeDB prizeDB= PrizeConvertor.toPrizeDB(entity);
      int update = prizeMapper.updateById(prizeDB);
      if (update <=0){
         throw new LDException("修改失败");
      }
      return PrizeConvertor.toPrizeEntity(prizeDB);
   }
   
   private PrizeEntity addPrize(PrizeEntity entity) {
      PrizeDB prizeDB= PrizeConvertor.toPrizeDB(entity);
      int insert = prizeMapper.insert(prizeDB);
      if (insert <=0){
         throw new LDException("添加失败");
      }
      return PrizeConvertor.toPrizeEntity(prizeDB);
   }
   
   @Override
   public IPage<PrizeEntity> page(PrizeListByParamQuery query) {
      IPage<PrizeDB> page = prizeMapper.page(new Page<PrizeDB>(query.getPageIndex(), query.getPageSize()), query);
      return page.convert(PrizeConvertor::toPrizeEntity);
   }
}
