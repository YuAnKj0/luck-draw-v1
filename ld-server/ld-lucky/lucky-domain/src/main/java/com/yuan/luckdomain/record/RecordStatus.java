package com.yuan.luckdomain.record;

import com.yuan.base.config.enums.RecordStatusEnum;
import com.yuan.base.config.utils.AssertUtil;

/**
 * @author Ykj
 * @date 2023/5/29/14:34
 * @apiNote
 */


public class RecordStatus {
   
   private RecordStatusEnum state;
   
   public Integer getStatus() {
       return this.state.getValue();
   }
   
   public RecordStatus(Integer state) {
      AssertUtil.isTrue(state<0,"记录状态无效");
      
      if (RecordStatusEnum.STATUE_0.getValue().equals(state)){
         this.state=RecordStatusEnum.STATUE_0;
         return;         
      }
      if (RecordStatusEnum.STATUE_1.getValue().equals(state)){
         this.state=RecordStatusEnum.STATUE_1;
         return;
      }
      if (RecordStatusEnum.STATUE_2.getValue().equals(state)){
         this.state=RecordStatusEnum.STATUE_2;
         return;
      }if (RecordStatusEnum.STATUE_3.getValue().equals(state)){
         this.state=RecordStatusEnum.STATUE_3;
         return;
      }
      if (RecordStatusEnum.STATUE_4.getValue().equals(state)){
         this.state=RecordStatusEnum.STATUE_4;
         return;
      }
      AssertUtil.isTrue(true, "记录状态无效！");
      
   }
}
