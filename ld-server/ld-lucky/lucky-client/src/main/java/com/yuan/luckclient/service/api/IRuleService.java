package com.yuan.luckclient.service.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckclient.service.dto.RuleAddCmd;
import com.yuan.luckclient.service.dto.RuleUpdateCmd;
import com.yuan.luckclient.service.dto.data.RuleVO;
import com.yuan.luckclient.service.dto.query.RuleListByParamQuery;

/**
 * @author Ykj
 * @date 2023/4/11/11:28
 * @apiNote
 */
public interface IRuleService {
   
    RuleVO add(RuleAddCmd cmd);
    RuleVO update(RuleUpdateCmd cmd);
    
    RuleVO one(Long id);
    
    IPage<RuleVO> page(RuleListByParamQuery query);
}
