package com.fly.service.impl;

import com.fly.entity.User;
import com.fly.repository.UserRepository;
import com.fly.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author : liufei on 2018/3/29
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public List<User> save(List<User> userList) {
        return userRepository.save(userList);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public int update(String username, Integer userId) {
        return userRepository.update(username, userId);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            userRepository.delete(id);
        }
    }
}
