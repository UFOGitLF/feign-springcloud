package com.fly.controller;

import com.fly.entity.User;
import com.fly.service.UserService;
import com.fly.utils.BaseAssert;
import com.fly.utils.Rr;
import com.fly.utils.ValidatorUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author : liufei on 2018/3/29
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Value("${server.port}")
    private Integer port;

    @Resource
    private UserService userService;

    @GetMapping
    @ApiOperation(value = "查询")
    public Rr getAll() {
        return Rr.ok(port);
    }

    @PostMapping
    @ApiOperation(value = "新增")
    public Rr save(@RequestBody List<User> userList) {
        if (!CollectionUtils.isEmpty(userList)) {
            for (User user : userList) {
                ValidatorUtils.validateEntity(user);
            }
        }
        return Rr.ok(userService.save(userList));
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Rr update(@RequestParam String username,
                     @RequestParam Integer userId) {

        BaseAssert.isBlank(username, "用户名格式错误");
        BaseAssert.isNull(userId, "用户ID格式错误");
        return Rr.ok(userService.update(username, userId));
    }

    @DeleteMapping
    @ApiOperation(value = "删除")
    public Rr delete(Integer[] ids) {
        BaseAssert.isNull(ids, "数据格式错误");
        if (ArrayUtils.isNotEmpty(ids)) {
            userService.delete(ids);
        }
        return Rr.ok();
    }
}
