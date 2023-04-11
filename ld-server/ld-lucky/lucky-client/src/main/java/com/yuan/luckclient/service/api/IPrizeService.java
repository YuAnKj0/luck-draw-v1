package com.yuan.luckclient.service.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckclient.service.dto.PrizeAddCmd;
import com.yuan.luckclient.service.dto.PrizeUpdateCmd;
import com.yuan.luckclient.service.dto.data.PrizeVO;
import com.yuan.luckclient.service.dto.query.PrizeListByParamQuery;

/**
 * @author Ykj
 * @date 2023/4/10/16:24
 * @apiNote
 */
public interface IPrizeService {
   /**
    * 增改查
    */
   
   PrizeVO add(PrizeAddCmd cmd);
   
   PrizeVO update(PrizeUpdateCmd cmd);
   IPage<PrizeVO> page(PrizeListByParamQuery query);
   
   PrizeVO one(Long id);
}
