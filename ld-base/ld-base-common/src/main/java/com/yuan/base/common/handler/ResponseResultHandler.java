package com.yuan.base.common.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuan.base.common.annotation.ResponseResult;
import com.yuan.base.config.vo.SuccessInfo;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

/**
 * @author Ykj
 * @date 2023/3/16/17:30
 * @apiNote
 */

@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {
   
   @Override
   public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
      
      final var method = methodParameter.getMethod();
      final var clazz = Objects.requireNonNull(method, "method is null").getDeclaringClass();
      
      // 只处理 ResponseResult 标注的类或方法
      var annotation = clazz.getAnnotation(ResponseResult.class);
      if (Objects.isNull(annotation)) {
         annotation = method.getAnnotation(ResponseResult.class);
      }
      
      //如果是FileSystemResource 则不拦截
      if (method.getAnnotatedReturnType().getType().getTypeName()
              .equals(FileSystemResource.class.getTypeName())) {
         return false;
      }
      return annotation != null && !annotation.ignore();
   }
   
   @SneakyThrows
   @Override
   public Object beforeBodyWrite(Object data,
                                 MethodParameter mediaType,
                                 MediaType selectedContentType,
                                 Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                 ServerHttpRequest request,
                                 ServerHttpResponse serverHttpResponse) {
      // 处理结果集
      var successInfo = SuccessInfo.builder()
              .data(data)
              .build();
      
      if ((data instanceof String) && !MediaType.APPLICATION_XML_VALUE.equals(mediaType.toString())) {
         ObjectMapper om = new ObjectMapper();
         serverHttpResponse.getHeaders().set("Content-Type", "application/json");
         return om.writeValueAsString(successInfo);
      }
      
      if (Objects.isNull(data) && MediaType.TEXT_HTML_VALUE.equals(mediaType.toString())) {
         ObjectMapper om = new ObjectMapper();
         serverHttpResponse.getHeaders().set("Content-Type", "application/json");
         return om.writeValueAsString(successInfo);
      }
      
      return successInfo;
   }
}
