package com.yuan.luckapp.rule.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckapp.assembler.RuleAssembler;
import com.yuan.luckclient.service.dto.data.RuleVO;
import com.yuan.luckclient.service.dto.query.RuleListByParamQuery;
import com.yuan.luckdomain.gateway.RuleGateway;
import com.yuan.luckdomain.rule.RuleEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Ykj
 * @date 2023/4/11/11:33
 * @apiNote
 */
@Slf4j
@Component
@AllArgsConstructor
public class RuleListByParamQueryExe {
   private final RuleGateway ruleGateway;
   public IPage<RuleVO> excute(RuleListByParamQuery query) {
      IPage<RuleEntity> page = ruleGateway.page(query);
      return page.convert(RuleAssembler::toRuleVO);
   }
}
