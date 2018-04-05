package com.fly.service;

import com.fly.entity.User;

import java.util.List;

/**
 * @Author : liufei on 2018/3/29
 */
public interface UserService {

    /**
     * get all users
     *
     * @return
     */
    List<User> findAll();

    /**
     * save users
     *
     * @param userList
     * @return
     */
    List<User> save(List<User> userList);

    /**
     * update user
     *
     * @param username
     * @param userId
     * @return
     */
    int update(String username, Integer userId);

    /**
     * delete users
     *
     * @param ids
     */
    void delete(Integer[] ids);
}
