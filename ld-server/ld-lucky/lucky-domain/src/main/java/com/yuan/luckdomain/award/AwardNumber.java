package com.yuan.luckdomain.award;

import com.yuan.base.config.exception.LDException;
import lombok.Data;

/**
 * @author Ykj
 * @date 2023/4/11/16:12
 * @apiNote
 */
@Data
public class AwardNumber {
   
   
   private Integer number;
   
   public AwardNumber(Integer number) {
      if (number < 0) {
         throw new LDException("奖项数量校验不合法");
      }
      this.number = number;
   }
}
