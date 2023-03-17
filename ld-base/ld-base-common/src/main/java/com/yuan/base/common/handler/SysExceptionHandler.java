package com.yuan.base.common.handler;

import cn.hutool.poi.excel.ExcelWriter;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import com.yuan.config.exception.LDException;
import com.yuan.config.exception.NoAuthException;
import com.yuan.config.vo.FailInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

import static io.prometheus.client.Counter.build;

/**
 * @author Ykj
 * @date 2023/3/17/9:24
 * @apiNote
 */

@RestControllerAdvice
@Slf4j
public class SysExceptionHandler {
   
   /**
    * 最大的兜底错误处理
    * @param e
    * @return
    */
   @ExceptionHandler(value = Exception.class)
   public FailInfo exception(Exception e){
      log.error("Exception information:{}", e.getMessage());
      log.error("Exception info:",e);
      var failInfo= FailInfo.builder().exception(e.getMessage()).build();   
      return failInfo;
   }
   
   @ExceptionHandler(value = BindException.class)
   public FailInfo exception(BindException e){
      String defaultMessage=Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
      log.error("Exception info:{}", e.getMessage());
      log.error("Exception info:",e);
      var failInfo= FailInfo.builder().exception(defaultMessage).build();
      return failInfo;
   }
   
   @ExceptionHandler(value = LDException.class)
   public FailInfo sysException(LDException e){
      log.error("Exception information:{}", e.getMessage());
      log.error("Exception info:",e);
      var failInfo= FailInfo.builder().exception(e.getMessage()).build();
      return failInfo;
   }
   
  /* @ExceptionHandler(value = NoAuthException.class)
   @ResponseBody
   public FailInfo sysException(NoAuthException e){
      log.error("Exception information:{}", e.getMessage());
      log.error("Exception info:",e);
      return new FailInfo(401,e.getMessage());
   }*/
  @ExceptionHandler(value = MysqlDataTruncation.class)
   public FailInfo mysqlDataTruncation(Exception e){
      log.error("Exception information:{}", e.getMessage());
      log.error("Exception info:",e);
     return new FailInfo(500,e.getMessage());
   }
   
   @ExceptionHandler(value = DataIntegrityViolationException.class)
   public FailInfo dataIntegrityViolationException(Exception e){
      log.error("Exception information:{}", e.getMessage());
      log.error("Exception info:",e);
      String message = e.getMessage();
      String[] split = message.split("\r\n###");
      for (String str : split) {
         if (str.trim().isBlank() || str.trim().contains("Error")){
            continue;
         }
         String[] split1 = str.split(":");
         if (split1.length>0){
            message=split1[split1.length-1].trim();
         }
      }
      return new FailInfo(500,message);
   }
   
   
}
