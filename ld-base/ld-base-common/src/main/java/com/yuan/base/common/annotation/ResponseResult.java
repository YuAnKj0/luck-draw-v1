package com.yuan.base.common.annotation;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * @author Ykj
 * @date 2023/3/16/17:24
 * @apiNote
 */

@Retention(RetentionPolicy.RUNTIME)  //作用时间
@Target({ElementType.TYPE,ElementType.METHOD}) //方法和类
@Documented
@RestController
public @interface ResponseResult {
    boolean ingore() default false;
   
}
