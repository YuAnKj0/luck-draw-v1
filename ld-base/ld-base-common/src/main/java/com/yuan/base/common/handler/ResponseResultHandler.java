package com.yuan.base.common.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuan.base.common.annotation.ResponseResult;
import com.yuan.config.vo.SuccessInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

/**
 * @author Ykj
 * @date 2023/3/16/17:30
 * @apiNote
 */

@Slf4j
@Component
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {
   
   @Override
   public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
      
      //如果是FileSystemResource则不拦截
      if (returnType.getMethod().getAnnotatedReturnType().getType().getTypeName()
              .equals(FileSystemResource.class.getTypeName())) {
         return false;
      }
      
      //判断是否增强，即判断是否有@ResponseResult这个注解，有的话就处理结果集
      ResponseResult annotation = returnType.getClass().getAnnotation(ResponseResult.class);
      if (Objects.isNull(annotation)){
          annotation = returnType.getMethod().getAnnotation(ResponseResult.class);
      }
      
      return annotation!=null && !annotation.ingore();
   }
   
   @Override
   public Object beforeBodyWrite(Object data, 
                                 MethodParameter mediaType, 
                                 MediaType selectedContentType, 
                                 Class<? extends HttpMessageConverter<?>> selectedConverterType, 
                                 ServerHttpRequest request, 
                                 ServerHttpResponse response) {
      //处理结果集
      var successInfo  =SuccessInfo.builder().data(data).build();
      if ((data instanceof String ) && !MediaType.APPLICATION_XML_VALUE.equals(mediaType.toString())) {
         try {
            ObjectMapper om=new ObjectMapper();
            request.getHeaders().set("Context-type","application/json");
            return om.writeValueAsString(successInfo);
         } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
         }
      }
      if (Objects.isNull(data) && !MediaType.TEXT_HTML_VALUE.equals(mediaType.toString())) {
         try {
            ObjectMapper om=new ObjectMapper();
            request.getHeaders().set("Context-type","application/json");
            return om.writeValueAsString(successInfo);
         } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
         }
      }
      
      
      return successInfo;
   }
}
