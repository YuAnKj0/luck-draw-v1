package com.yuan.base.config.utils;

import java.util.Map;
import java.util.Objects;

/**
 * @author Ykj
 * @date 2023/3/30/11:12
 * @apiNote
 */
public class SecurityUtil {
   
   private static ThreadLocal<Map<String, Object>> userThreadLocal=new ThreadLocal<>();
   
   public static void addConfig(Map<String,Object> user){
      userThreadLocal.set(user);
   }
   
   public static void remove(){
      userThreadLocal.remove();
   }
   
   public static String getUserName(){
      Object userName = userThreadLocal.get().get("username");
      return Objects.isNull(userName) ? "" : userName.toString();
   }
   
   public static String getName(){
      Object name = userThreadLocal.get().get("name");
      return Objects.isNull(name) ? "" : name.toString();
   }
   
   public static Long getUserId(){
      Object id = userThreadLocal.get().get("id");
      return Objects.isNull(id)?0L:Long.parseLong(id.toString());
      
   }
   public static String get(String key) {
      Object value = userThreadLocal.get().get(key);
      
      return Objects.isNull(value) ? "" : value.toString();
   }
   
   
   
}
