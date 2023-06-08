package com.yuan.luckapp.listener.event;

import com.yuan.luckclient.service.dto.data.ActivityConfigVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

/**
 * @author Ykj
 * @date 2023/5/17/9:53
 * @apiNote
 */

@Slf4j
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
