package com.yuan.luckadapter.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.base.common.annotation.ResponseResult;
import com.yuan.luckclient.service.api.IActivityConfigService;
import com.yuan.luckclient.service.api.IActivityService;
import com.yuan.luckclient.service.dto.data.ActivityConfigVO;
import com.yuan.luckclient.service.dto.data.ActivityVO;
import com.yuan.luckclient.service.dto.data.DrawResultVO;
import com.yuan.luckclient.service.dto.query.ActivityListByParamQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ykj
 * @date 2023/6/2/11:29
 * @apiNote
 */
@Slf4j
@AllArgsConstructor
@ResponseResult
@RequestMapping("/v1/activity")
public class ActivityController {
  
  private final IActivityConfigService activityConfigService;
  private final IActivityService activityService;
  
  @PostMapping("/page")
  public IPage<ActivityVO> page(@RequestBody ActivityListByParamQuery query){
    return activityService.page(query);
  }  
  
  @GetMapping("/one")
  public ActivityConfigVO one(@RequestParam("id") Long id){
    return activityConfigService.one(id);
  }

  @GetMapping("draw")
  public DrawResultVO draw(@RequestParam("activityId") Long activityId){
    return activityService.draw(activityId);

  }
}
