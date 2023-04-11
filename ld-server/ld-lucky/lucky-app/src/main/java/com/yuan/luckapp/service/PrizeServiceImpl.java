package com.yuan.luckapp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckapp.prize.command.PrizeAddCmdExe;
import com.yuan.luckapp.prize.command.PrizeUpdateCmdExe;
import com.yuan.luckapp.prize.query.PrizeListByParamQueryExe;
import com.yuan.luckclient.service.api.IPrizeService;
import com.yuan.luckclient.service.dto.PrizeAddCmd;
import com.yuan.luckclient.service.dto.PrizeUpdateCmd;
import com.yuan.luckclient.service.dto.data.PrizeVO;
import com.yuan.luckclient.service.dto.query.PrizeListByParamQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * @author Ykj
 * @date 2023/4/10/16:37
 * @apiNote
 */

@Slf4j
@Service
@AllArgsConstructor
public class PrizeServiceImpl implements IPrizeService {
   
   private final PrizeAddCmdExe prizeAddCmdExe;
   private final PrizeUpdateCmdExe prizeUpdateCmdExe;
   private final PrizeListByParamQueryExe prizeListByParamQueryExe;
   
   /**
    * 增改查
    *
    * @param cmd
    */
   @Override
   public PrizeVO add(PrizeAddCmd cmd) {
      return prizeAddCmdExe.excute(cmd);
   }
   
   @Override
   public PrizeVO update(PrizeUpdateCmd cmd) {
      return prizeUpdateCmdExe.excute(cmd);
   }
   
   @Override
   public IPage<PrizeVO> page(PrizeListByParamQuery query) {
      return prizeListByParamQueryExe.execute(query);
   }
   
   @Override
   public PrizeVO one(Long id) {
      final var query = new PrizeListByParamQuery();
      query.setId(id);
      IPage<PrizeVO> page = page(query);
      if (CollectionUtils.isEmpty(page.getRecords())) {
         return null;
      }
      
      return page.getRecords().get(0);
   }
}
