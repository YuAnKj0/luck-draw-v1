package com.yuan.luckapp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckclient.service.api.IRecordService;
import com.yuan.luckclient.service.dto.RecordAddCmd;
import com.yuan.luckclient.service.dto.RecordUpdateStatusCmd;
import com.yuan.luckclient.service.dto.data.RecordVO;
import com.yuan.luckclient.service.dto.query.RecordListByParamQuery;

/**
 * @author Ykj
 * @date 2023/5/18/16:46
 * @apiNote
 */


public class RecordServiceImpl implements IRecordService { 

   
   @Override
   public IPage<RecordVO> page(RecordListByParamQuery query) {
      return null;
   }
   
   @Override
   public RecordVO add(RecordAddCmd cmd) {
      return null;
   }
   
   @Override
   public Integer prizeType(Long recordId) {
      return null;
   }
   
   @Override
   public Boolean update(RecordUpdateStatusCmd cmd) {
      return null;
   }
   
   @Override
   public Boolean exchangeMoney(Long recordId) {
      return null;
   }
}
