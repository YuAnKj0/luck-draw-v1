package com.yuan.luckadapter.web.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.base.common.annotation.ResponseResult;
import com.yuan.luckclient.service.api.IPrizeService;
import com.yuan.luckclient.service.dto.PrizeAddCmd;
import com.yuan.luckclient.service.dto.PrizeUpdateCmd;
import com.yuan.luckclient.service.dto.data.PrizeVO;
import com.yuan.luckclient.service.dto.query.PrizeListByParamQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ykj
 * @date 2023/4/11/10:51
 * @apiNote
 */
@Slf4j
@AllArgsConstructor
@ResponseResult
@RequestMapping("/admin/v1/prize")
public class AdminPrizeController {
   
   private final IPrizeService iPrizeService;
   
   @PostMapping("/add")
   public PrizeVO add(@Validated @RequestBody PrizeAddCmd cmd){
      return iPrizeService.add(cmd);
   }
   @PostMapping("/add")
   public PrizeVO update(@Validated @RequestBody PrizeUpdateCmd cmd){
      return iPrizeService.update(cmd);
   }
   @PostMapping("/page")
   public IPage<PrizeVO> page(@RequestBody PrizeListByParamQuery query){
      return iPrizeService.page(query);
   }
   
   @GetMapping("/one")
   public PrizeVO one(@PathVariable(name = "id") Long id){
      return iPrizeService.one(id);
   }
   
}
