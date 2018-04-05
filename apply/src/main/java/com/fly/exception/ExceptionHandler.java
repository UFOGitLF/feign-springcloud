package com.fly.exception;

import com.fly.utils.Rr;
import feign.FeignException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author : liufei on 2018/3/29
 */
@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(FeignException.class)
    public Rr handleFeignException() {
        return Rr.error("Feign 调用失败!!!");
    }


}
