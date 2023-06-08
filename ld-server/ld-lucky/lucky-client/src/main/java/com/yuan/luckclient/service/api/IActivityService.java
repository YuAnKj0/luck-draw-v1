package com.yuan.luckclient.service.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckclient.service.dto.ActivityAddCmd;
import com.yuan.luckclient.service.dto.ActivityUpdateCmd;
import com.yuan.luckclient.service.dto.data.ActivityVO;
import com.yuan.luckclient.service.dto.data.DrawResultVO;
import com.yuan.luckclient.service.dto.query.ActivityListByParamQuery;

/**
 * @author Ykj
 * @date 2023/4/21/11:56
 * @apiNote
 */
public interface IActivityService {
    
    ActivityVO add(ActivityAddCmd cmd);
    
    ActivityVO update(ActivityUpdateCmd cmd);
    
    IPage<ActivityVO> page(ActivityListByParamQuery query );
    
    ActivityVO one(Long id);

    /**
     * 用户抽奖接口
     * @param activityId
     * @return
     */
    DrawResultVO draw(Long activityId);
   
   
}
