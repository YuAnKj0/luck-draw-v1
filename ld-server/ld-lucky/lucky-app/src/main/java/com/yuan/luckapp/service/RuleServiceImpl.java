package com.yuan.luckapp.service;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckapp.rule.command.RuleAddCmdExe;
import com.yuan.luckapp.rule.command.RuleUpdateCmdExe;
import com.yuan.luckapp.rule.query.RuleListByParamQueryExe;
import com.yuan.luckclient.service.api.IRuleService;
import com.yuan.luckclient.service.dto.RuleAddCmd;
import com.yuan.luckclient.service.dto.RuleUpdateCmd;
import com.yuan.luckclient.service.dto.data.RuleVO;
import com.yuan.luckclient.service.dto.query.RuleListByParamQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Ykj
 * @date 2023/4/11/11:30
 * @apiNote
 */
@Slf4j
@Service
@AllArgsConstructor
public class RuleServiceImpl implements IRuleService {
   
   private final RuleAddCmdExe ruleAddCmdExe;
   private final RuleUpdateCmdExe ruleUpdateCmdExe;
   private final RuleListByParamQueryExe ruleListByParamQueryExe;
   @Override
   public RuleVO add(RuleAddCmd cmd) {
      return ruleAddCmdExe.excute(cmd);
   }
   
   @Override
   public RuleVO update(RuleUpdateCmd cmd) {
      return ruleUpdateCmdExe.excute(cmd);
   }
   
   @Override
   public RuleVO one(Long id) {
      RuleListByParamQuery query = new RuleListByParamQuery();
      query.setId(id);
      IPage<RuleVO> page = page(query);
      if (CollUtil.isEmpty(page.getRecords())){
         return null;
      }
      return page.getRecords().get(0);
   }
   
   @Override
   public IPage<RuleVO> page(RuleListByParamQuery query) {
      return ruleListByParamQueryExe.excute(query);
   }
}
