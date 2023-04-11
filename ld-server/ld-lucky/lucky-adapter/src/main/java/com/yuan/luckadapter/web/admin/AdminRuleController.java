package com.yuan.luckadapter.web.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.base.common.annotation.ResponseResult;
import com.yuan.luckclient.service.api.IRuleService;
import com.yuan.luckclient.service.dto.RuleAddCmd;
import com.yuan.luckclient.service.dto.RuleUpdateCmd;
import com.yuan.luckclient.service.dto.data.RuleVO;
import com.yuan.luckclient.service.dto.query.RuleListByParamQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ykj
 * @date 2023/4/11/14:57
 * @apiNote
 */
@Slf4j
@AllArgsConstructor
@ResponseResult
@RequestMapping("/admin/v1/rule")
public class AdminRuleController {
   
   private final IRuleService ruleService;
   
   @PostMapping("/add")
   public RuleVO add(@Validated @RequestBody RuleAddCmd cmd){
      return ruleService.add(cmd);
   } 
   @PostMapping("/update")
   public RuleVO update(@Validated @RequestBody RuleUpdateCmd cmd){
      return ruleService.update(cmd);
   }
   @PostMapping("/page")
   public IPage<RuleVO> page(@RequestBody RuleListByParamQuery query){
      return ruleService.page(query);
   }
   @GetMapping("/{id}")
   public RuleVO one(@PathVariable(name = "id") Long id){
      return ruleService.one(id);
   }
   
}
