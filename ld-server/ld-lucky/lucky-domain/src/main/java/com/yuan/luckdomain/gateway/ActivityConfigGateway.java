package com.yuan.luckdomain.gateway;

import com.yuan.luckclient.service.dto.data.ActivityConfigVO;

/**
 * @author Ykj
 * @date 2023/4/28/14:42
 * @apiNote
 */


public interface ActivityConfigGateway {
   
   ActivityConfigVO save(ActivityConfigVO vo);
   
   ActivityConfigVO one(Long id);
}
