package com.yuan.luckinfrastrusture.gateway.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.base.config.exception.LDException;
import com.yuan.luckclient.service.dto.query.AwardListByParamQuery;
import com.yuan.luckdomain.award.AwardEntity;
import com.yuan.luckdomain.gateway.AwardGateway;
import com.yuan.luckinfrastrusture.convertor.AwardConvertor;
import com.yuan.luckinfrastrusture.gateway.impl.dataobject.AwardDB;
import com.yuan.luckinfrastrusture.gateway.impl.mapper.AwardMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author Ykj
 * @date 2023/4/11/18:13
 * @apiNote
 */
@Slf4j
@Component
@AllArgsConstructor
public class AwardGatewayImpl implements AwardGateway {
   private final AwardMapper awardMapper;
   
   
   @Override
   public AwardEntity save(AwardEntity entity) {
      if (Objects.isNull(entity.getId())){
         return addAward(entity);
      }
      return updateAward(entity);
   }
   
   private AwardEntity updateAward(AwardEntity entity) {
      AwardDB awardDB = AwardConvertor.toAwardDB(entity);
      int update = awardMapper.updateById(awardDB);
      if (update < 0){
         throw new LDException("修改失败");
      }
      return AwardConvertor.toAwardEntity(awardDB);
   }
   
   private AwardEntity addAward(AwardEntity entity) {
      AwardDB awardDB = AwardConvertor.toAwardDB(entity);
      int insert = awardMapper.insert(awardDB);
      if (insert < 0){
         throw new LDException("添加失败");
      }
      return AwardConvertor.toAwardEntity(awardDB);
   }
   
   @Override
   public IPage<AwardEntity> page(AwardListByParamQuery query) {
      IPage<AwardDB> page=awardMapper.page(new Page<AwardDB>(query.getPageIndex(),query.getPageSize()),query);
      return page.convert(AwardConvertor::toAwardEntity);
   }
}
