package com.yuan.luckdomain.user;

import cn.hutool.crypto.digest.MD5;
import lombok.Getter;
import lombok.Setter;


/**
 * @author Ykj
 * @date 2023/3/20/15:49
 * @apiNote
 */
@Getter
@Setter
public class PassWord {
   
   private EncryptionPassWord encryptionPassWord;
   
   public PassWord(EncryptionPassWord encryptionPassWord) {
      this.encryptionPassWord = encryptionPassWord;
   }
   
   /**
    * 得到加密后的密码
    * @param password
    * @return
    */
   public static String getEncryptionPassWord(String password){
      return MD5.create().digestHex(password);
   }
   
   @Getter
   public static class EncryptionPassWord{
      private String password;
      
      public EncryptionPassWord(String password){
         this.password=password;
      }
      
   }
   
   /**
    * 判断两个密码是否相等
    */
   public Boolean isEqual(String password){
      return this.encryptionPassWord.password.equals(getEncryptionPassWord(password));
   }
   
   
}
