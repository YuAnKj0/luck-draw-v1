package com.yuan.base.config.utils;

import com.yuan.base.config.exception.LDException;

/**
 * @author Ykj
 * @date 2023/4/23/10:37
 * @apiNote
 */


public class AssertUtil {
   
   /**
    * expression is true throw the message
    * @param expression
    * @param message
    */
   public static void isTrue(Boolean expression,String message){
      if (expression){
         throw new LDException(message);
      }
   }
   
   /**
    * expression is false throw the message
    * @param expression
    * @param message
    */
   public static void isFalse(Boolean expression,String message){
      if (!expression){
         throw new LDException(message);
      }
   }
}
