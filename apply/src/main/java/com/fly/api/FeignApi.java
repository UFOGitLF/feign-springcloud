package com.fly.api;

import com.fly.utils.Rr;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author : liufei on 2018/3/29
 */
@FeignClient(name = "service-provider")
public interface FeignApi {
    /**
     * feign 调用查询所有用户
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/user")
    Rr getUsers(@RequestParam(value = "pageNo") Integer pageNo,@RequestParam(value = "pageSize") Integer pageSize);
}
