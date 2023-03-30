package com.yuan.base.common.interceptor;

import com.yuan.base.config.utils.SecurityUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Ykj
 * @date 2023/3/30/15:25
 * @apiNote
 */
public class SecurityInterceptor implements HandlerInterceptor {
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      Map<String, Object> userMap = new HashMap<>();
      
      String name = URLDecoder.decode(Objects.isNull(request.getHeader("name")) ? "" : request.getHeader("name"), "UTF-8");
      String username = URLDecoder.decode(Objects.isNull(request.getHeader("username")) ? "" : request.getHeader("username"), "UTF-8");
      String id = request.getHeader("id");
      String phone = request.getHeader("phone");
      
      userMap.put("name", name);
      userMap.put("username", username);
      userMap.put("id", id);
      userMap.put("phone", phone);
      
      SecurityUtil.addConfig(userMap);
      return HandlerInterceptor.super.preHandle(request, response, handler);
   }
   
   @Override
   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
      SecurityUtil.remove();
      HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
   }
}
