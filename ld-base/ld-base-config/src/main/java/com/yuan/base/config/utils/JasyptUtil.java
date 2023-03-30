package com.yuan.base.config.utils;


import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

/**
 * @author Ykj
 * @date 2023/3/17/10:25
 * @apiNote
 */
public class JasyptUtil {
   
   /**
    * 加密和解密使用的盐
    */
   private static String password="161435";
   private static String prefix="ENC(";
   private static String suffix=")";
   private static PooledPBEStringEncryptor encryptor;
   
   static {
      encryptor = new PooledPBEStringEncryptor();
      encryptor.setConfig(getConfig());
   }
   
   public static void main(String[] args) {
      String encrypt = encrypt("6379");
      System.out.println(prefix+encrypt+suffix);
      String decrypt = decrypt(encrypt);
      System.out.println(decrypt);
   
   }
   
   
   /**
    * Jasypt 加密
    *
    * @param encrypt 加密字符串
    * @return
    */
   public static String encrypt(String encrypt) {
      return encryptor.encrypt(encrypt);
   }
   
   public static String decrypt(String encrypt) {
      return encryptor.decrypt(encrypt);
   }
   
   public static SimpleStringPBEConfig getConfig() {
      SimpleStringPBEConfig config=new SimpleStringPBEConfig();
      config.setPassword(password);
      config.setKeyObtentionIterations("1000");
      config.setPoolSize(1);
      config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
      config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
      config.setStringOutputType("base64");
      return config;
   }
}
