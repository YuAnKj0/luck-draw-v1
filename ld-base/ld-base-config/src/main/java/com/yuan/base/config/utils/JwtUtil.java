package com.yuan.base.config.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yuan.base.config.exception.TokenAuthException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Ykj
 * @date 2023/3/29/23:05
 * @apiNote
 */
public class JwtUtil {
   /**
    * 密钥
    */
   private static final String SECRET="YuAnKj0";
   /**
    * 过期时间
    */
   private static final Long EXPORATION =2*24*60*60L;

   /**
    * 生成用户token，设置token过期时间，添加用户信息，可以放在map中
    * @param params
    * @return
    */
   public static String createToken(Map<String, Object> params) {
      Date expireDate=new Date(System.currentTimeMillis()+EXPORATION*1000);
      Map<String,Object> header = new HashMap<String,Object>();
      header.put("alg","HS256");
      header.put("typ","JWT");
      //添加header
      JWTCreator.Builder builder= JWT.create().withHeader(header);
      //信息体
      params.forEach((k,v)->builder.withClaim(k,v.toString()));
      return builder.withExpiresAt(expireDate)//超时设置，设置过期日期
              .withIssuedAt(new Date())//签发时间
              .sign(Algorithm.HMAC256(SECRET));//SECRET加密
      
   }
   public static Map<String, Object> verifyToken(String token){
      DecodedJWT jwt=null;
      Map<String,Object> result=new HashMap<>();
      try {
         JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
         jwt = verifier.verify(token);
         jwt.getClaims().forEach((k,v)->result.put(k,v.asString()));

      }catch (Exception e){
         //System.out.println("verifyToken_error");
         throw new TokenAuthException(e.getMessage());
      }
      return result;
      
   }
   
   
   
}
