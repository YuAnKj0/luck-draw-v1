package com.yuan.luckadapter.web.admin;

import com.yuan.base.common.annotation.ResponseResult;
import com.yuan.luckclient.service.api.IActivityConfigService;
import com.yuan.luckclient.service.dto.ActivityConfigAddCmd;
import com.yuan.luckclient.service.dto.data.ActivityConfigCopyVO;
import com.yuan.luckclient.service.dto.data.ActivityConfigVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ykj
 * @date 2023/5/17/10:50
 * @apiNote
 */

@Slf4j
@AllArgsConstructor
@ResponseResult
@RequestMapping("/admin/v1/activityConfig")
public class AdminActivityConfigController {
   
   private final IActivityConfigService iActivityConfigService;
   
   @PostMapping("/add")
   public ActivityConfigVO add(@Validated @RequestBody ActivityConfigAddCmd activityConfigAddCmd){
      return iActivityConfigService.add(activityConfigAddCmd);
   }
   
   @GetMapping("/one")
   public ActivityConfigVO one(@RequestParam("id") Long id){
      return iActivityConfigService.one(id);
   }
   
   @GetMapping("/copy")
   public ActivityConfigCopyVO copy(@RequestParam("id") Long id){
      return iActivityConfigService.copy(id);
   }
}
