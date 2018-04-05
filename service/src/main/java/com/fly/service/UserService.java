package com.fly.service;

import com.fly.entity.User;
import com.fly.entity.UserQuery;
import org.springframework.data.domain.Page;

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
     * find all by sort
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<User> findAll(Integer pageNo,Integer pageSize);

    /**
     * query by condition
     * @param pageNo
     * @param pageSize
     * @param userQuery
     * @return
     */
    Page<User> findAll(Integer pageNo, Integer pageSize, UserQuery userQuery);
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
