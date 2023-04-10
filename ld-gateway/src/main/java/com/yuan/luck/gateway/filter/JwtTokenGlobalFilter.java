package com.yuan.luck.gateway.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuan.base.config.exception.LDException;
import com.yuan.base.config.utils.JwtUtil;
import com.yuan.base.config.utils.SecurityUtil;
import com.yuan.base.config.vo.FailInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;

import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


/**
 * @author Ykj
 * @date 2023/4/10/9:34
 * @apiNote
 */
@Component
@Slf4j
@Order(-100)
@Data
@ConfigurationProperties(prefix = "ld.jwt.token.filter")
public class JwtTokenGlobalFilter  implements GlobalFilter {
   private final ObjectMapper objectMapper;
   
   private  Set<String> ignoreUrlSet = Set.of(
           "user/login",
           "user.register"
   );
   
   private  String authorization="Authorization";
   public JwtTokenGlobalFilter(ObjectMapper objectMapper){
      this.objectMapper=objectMapper;
   }
   
   @Override
   public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
      //获取请求URL
      String url = exchange.getRequest().getURI().getPath();
      
      //忽略认证
      for (String ignoreUrl:ignoreUrlSet){
         if (Boolean.TRUE.equals(ignore(url,ignoreUrl))){
            return chain.filter(exchange);
         }
      }
      //认证逻辑
      String token = exchange.getRequest().getHeaders().getFirst(authorization);
      ServerHttpResponse response = exchange.getResponse();
      try {
         
         Map<String, Object> userMap = JwtUtil.verifyToken(token);
         SecurityUtil.addConfig(userMap);
         return chain.filter(exchange);
      }catch (Exception e) {
          //错误处理
         log.error("token认证失败");
         //写一个统一错误字符串
         return autoError(response,"认证出错，请重新登录！");
      }
     
   }
   
   private Mono<Void> autoError(ServerHttpResponse response, String message) {
      response.setStatusCode(HttpStatus.UNAUTHORIZED);
      response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
      String returnStr="";
      try {
         returnStr = objectMapper.writeValueAsString(new FailInfo(message));
      }catch (JsonProcessingException e){
         log.error(e.getMessage(), e);
      }
      DataBuffer buffer = response.bufferFactory().wrap(returnStr.getBytes(StandardCharsets.UTF_8));
      return response.writeWith(Flux.just(buffer));
   }
   

   
   /**
    * 忽略逻辑
    * 1.判断字符串存在（方法，当前使用）
    * 2.正则表达式
    * 3.
    * @param  url：request url     
    * @param ignoreUrl ignored url
    * @return
    */
   private boolean ignore(String url, String ignoreUrl) {
      if (Objects.isNull(url)){
         throw new LDException("request url is error");
      }
      return (url.contains(ignoreUrl));
   }
   
}
