package com.yuan.luckapp.prize.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckapp.assembler.PrizeAssembler;
import com.yuan.luckclient.service.dto.data.PrizeVO;
import com.yuan.luckclient.service.dto.query.PrizeListByParamQuery;
import com.yuan.luckdomain.gateway.PrizeGateway;
import com.yuan.luckdomain.prize.PrizeEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Ykj
 * @date 2023/4/10/16:44
 * @apiNote
 */
@Slf4j
@Component
@AllArgsConstructor
public class PrizeListByParamQueryExe {
   private final PrizeGateway prizeGateway;
   
   
   public IPage<PrizeVO> execute(PrizeListByParamQuery query) {
      IPage<PrizeEntity> page = prizeGateway.page(query);
      
      return page.convert(PrizeAssembler::toPrizeVO);
   }
}
