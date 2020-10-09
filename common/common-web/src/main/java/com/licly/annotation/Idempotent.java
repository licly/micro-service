package com.licly.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 幂等接口注解
 *
 * @author licly
 * @date 2020/10/9
 */

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Idempotent {

    /**
     * 判断是否是同一个请求的参数
     */
    String[] params() default {};

    /**
     * 回滚方法
     */
    String rollbackMethod() default "";
}
