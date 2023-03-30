package com.yuan.base.config.exception;

/**
 * @author Ykj
 * @date 2023/3/17/9:35
 * @apiNote
 */
public class LDException extends RuntimeException{
   public LDException(){}
   
   public LDException(String message,Object ... args){
      super(String.format(message, args));
   }
   
   public LDException(String message,Throwable cause,Object ... args){
      super(String.format(message,args), cause);
   }
   public LDException(Throwable cause){super(cause);}
   
   
}
