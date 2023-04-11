package com.yuan.luckadapter.web.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.base.common.annotation.ResponseResult;
import com.yuan.luckclient.service.api.IAwardService;
import com.yuan.luckclient.service.dto.AwardAddCmd;
import com.yuan.luckclient.service.dto.AwardUpdateCmd;
import com.yuan.luckclient.service.dto.data.AwardVO;
import com.yuan.luckclient.service.dto.query.AwardListByParamQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.TypeCollector;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ykj
 * @date 2023/4/11/18:48
 * @apiNote
 */
@Slf4j
@AllArgsConstructor
@ResponseResult
@RequestMapping("/admin/v1/award")
public class AdminAwardController {
   
   private final IAwardService awsService;
   
   @PostMapping("/add")
   public AwardVO add(@Validated @RequestBody AwardAddCmd cmd){
      return awsService.add(cmd);
   }
   
   @PostMapping("/update")
   public AwardVO update(@Validated @RequestBody AwardUpdateCmd cmd){
      return awsService.update(cmd);
   }
   
   @GetMapping("/{id}")
   public AwardVO one(@PathVariable(name = "id") Long id){
      return awsService.one(id);
   }
   
   public IPage<AwardVO> page(@RequestBody AwardListByParamQuery query){
      return awsService.page(query);
   }
}
