package com.yuan.base.common.annotation;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * @author Ykj
 * @date 2023/3/16/17:24
 * @apiNote
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@RestController // 组合
public @interface ResponseResult {
    // 是否忽略
    boolean ignore() default false;
}
