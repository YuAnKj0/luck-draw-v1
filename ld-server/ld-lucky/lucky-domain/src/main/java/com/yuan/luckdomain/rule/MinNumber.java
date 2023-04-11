package com.yuan.luckdomain.rule;

import com.yuan.base.config.exception.LDException;
import lombok.Data;
import lombok.Getter;
import org.springframework.boot.convert.DataSizeUnit;

import java.net.PortUnreachableException;

/**
 * @author Ykj
 * @date 2023/4/11/11:15
 * @apiNote
 */
@Getter
public class MinNumber {
   private Integer number;
   
   public MinNumber(Integer number){
      if (number <1){
         throw new LDException("数量必须大于1");
      }
      this.number = number;
   }
   
}
