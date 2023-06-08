package com.yuan.luckapp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.luckapp.record.command.RecordAddCmdExe;
import com.yuan.luckapp.record.query.RecordListByParamQueryExe;
import com.yuan.luckclient.service.api.IRecordService;
import com.yuan.luckclient.service.dto.RecordAddCmd;
import com.yuan.luckclient.service.dto.RecordUpdateStatusCmd;
import com.yuan.luckclient.service.dto.data.RecordVO;
import com.yuan.luckclient.service.dto.query.RecordListByParamQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Ykj
 * @date 2023/5/18/16:46
 * @apiNote
 */

@Slf4j
@Service
@AllArgsConstructor
public class RecordServiceImpl implements IRecordService { 
   private final RecordAddCmdExe recordAddCmdExe;
   private final RecordListByParamQueryExe recordListByParamQueryExe;

   
   @Override
   public IPage<RecordVO> page(RecordListByParamQuery query) {
      return recordListByParamQueryExe.page(query);
   }
   
   @Override
   public RecordVO add(RecordAddCmd cmd) {
      return recordAddCmdExe.add(cmd);
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
