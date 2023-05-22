package com.yuan.luckclient.service.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckclient.service.dto.RecordAddCmd;
import com.yuan.luckclient.service.dto.RecordUpdateStatusCmd;
import com.yuan.luckclient.service.dto.data.RecordVO;
import com.yuan.luckclient.service.dto.query.RecordListByParamQuery;

/**
 * @author Ykj
 * @date 2023/5/18/16:36
 * @apiNote
 */


public interface IRecordService {
   
   
   IPage<RecordVO> page(RecordListByParamQuery query);
   
   RecordVO add(RecordAddCmd cmd);
   
   Integer prizeType(Long recordId);
   
   Boolean update(RecordUpdateStatusCmd cmd);
   
   Boolean exchangeMoney(Long recordId);
}
