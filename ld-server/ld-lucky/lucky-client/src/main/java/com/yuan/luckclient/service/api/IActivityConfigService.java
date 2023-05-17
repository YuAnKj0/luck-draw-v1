package com.yuan.luckclient.service.api;

import com.yuan.luckclient.service.dto.ActivityConfigAddCmd;
import com.yuan.luckclient.service.dto.ActivityConfigUpdateCmd;
import com.yuan.luckclient.service.dto.data.ActivityConfigCopyVO;
import com.yuan.luckclient.service.dto.data.ActivityConfigVO;

/**
 * @author Ykj
 * @date 2023/4/25/16:28
 * @apiNote
 */


public interface IActivityConfigService {
    
    ActivityConfigVO add(ActivityConfigAddCmd activityConfigcmd);
    
    ActivityConfigVO update(ActivityConfigUpdateCmd configUpdateCmd);
    ActivityConfigVO one(Long id);
    
    ActivityConfigCopyVO copy(Long id);
   
   
}
