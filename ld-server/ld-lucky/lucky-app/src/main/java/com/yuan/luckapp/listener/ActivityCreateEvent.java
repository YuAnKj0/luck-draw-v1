package com.yuan.luckapp.listener;

import com.yuan.luckclient.service.dto.data.ActivityConfigVO;
import org.springframework.context.ApplicationEvent;

/**
 * @author Ykj
 * @date 2023/5/17/9:53
 * @apiNote
 */


public class ActivityCreateEvent extends ApplicationEvent {
   private final ActivityConfigVO activityConfigVO;
   
   public ActivityConfigVO getActivityConfig() {
      return activityConfigVO;
   }
   public ActivityCreateEvent(Object source, ActivityConfigVO activityConfigVO) {
      super(source);
      this.activityConfigVO = activityConfigVO;
   }
}
