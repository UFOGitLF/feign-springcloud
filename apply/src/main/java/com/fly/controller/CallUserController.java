package com.fly.controller;

import com.fly.annotation.SysLog;
import com.fly.api.FeignApi;
import com.fly.utils.Rr;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author : liufei on 2018/3/29
 */
@RestController
@RequestMapping(value = "v2")
public class CallUserController {

    @Resource
    private FeignApi feignApi;

    @GetMapping("do")
    @SysLog("Feign 调用获取所有用户")
    public Rr show(@RequestParam(required = false,defaultValue = "1") Integer pageNo,
                   @RequestParam(required = false,defaultValue = "10") Integer pageSize) {
        return Rr.ok(feignApi.getUsers(pageNo,pageSize).get("data"));
    }
}
