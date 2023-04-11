package com.yuan.luckclient.service.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckclient.service.dto.AwardAddCmd;
import com.yuan.luckclient.service.dto.AwardUpdateCmd;
import com.yuan.luckclient.service.dto.PrizeAddCmd;
import com.yuan.luckclient.service.dto.PrizeUpdateCmd;
import com.yuan.luckclient.service.dto.data.AwardVO;
import com.yuan.luckclient.service.dto.data.PrizeVO;
import com.yuan.luckclient.service.dto.query.AwardListByParamQuery;
import com.yuan.luckclient.service.dto.query.PrizeListByParamQuery;

/**
 * @author Ykj
 * @date 2023/4/11/16:06
 * @apiNote
 */
public interface IAwardService {
   
   AwardVO add(AwardAddCmd cmd);
   
   AwardVO update(AwardUpdateCmd cmd);
   AwardVO one(Long id);
   IPage<AwardVO> page(AwardListByParamQuery query);
   
}
