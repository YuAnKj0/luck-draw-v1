package com.yuan.luckapp.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.luckapp.award.command.AwardAddCmdExe;
import com.yuan.luckapp.award.command.AwardUpdateCmdExe;
import com.yuan.luckapp.award.query.AwardListByParamQueryExe;
import com.yuan.luckclient.service.api.IAwardService;
import com.yuan.luckclient.service.dto.AwardAddCmd;
import com.yuan.luckclient.service.dto.AwardUpdateCmd;
import com.yuan.luckclient.service.dto.data.AwardVO;
import com.yuan.luckclient.service.dto.query.AwardListByParamQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * @author Ykj
 * @date 2023/4/11/17:41
 * @apiNote
 */
@Slf4j
@Service
@AllArgsConstructor
public class AwardServiceImpl implements IAwardService {
   private final AwardAddCmdExe awardAddCmdExe;
   private final AwardUpdateCmdExe awardUpdateCmdExe;
   private final AwardListByParamQueryExe awardListByParamQueryExe;
   
   @Override
   public AwardVO add(AwardAddCmd cmd) {
      return  awardAddCmdExe.excute(cmd);
   }
   
   @Override
   public AwardVO update(AwardUpdateCmd cmd) {
      return  awardUpdateCmdExe.excute(cmd);
   }
   
   @Override
   public AwardVO one(Long id) {
      final var query=new AwardListByParamQuery();
      query.setId(id);
      IPage<AwardVO> page = page(query);
      if (CollectionUtil.isEmpty(page.getRecords())){
         return null;
      }
      return page.getRecords().get(0);
   }
   
   @Override
   public IPage<AwardVO> page(AwardListByParamQuery query) {
      return awardListByParamQueryExe.execute(query);
   }
}
