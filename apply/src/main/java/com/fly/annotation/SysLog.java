package com.fly.annotation;

import java.lang.annotation.*;

/**
 * @Author : liufei on 2018/4/3
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    String value() default "";
}
