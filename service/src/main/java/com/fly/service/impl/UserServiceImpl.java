package com.fly.service.impl;

import com.fly.entity.User;
import com.fly.entity.UserQuery;
import com.fly.repository.UserRepository;
import com.fly.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
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
    public Page<User> findAll(Integer pageNo,Integer pageSize) {
        Pageable pageable = new PageRequest(pageNo-1,pageSize, Sort.Direction.ASC,"id");
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> findAll(Integer pageNo, Integer pageSize, UserQuery userQuery) {

        Pageable pageable = new PageRequest(pageNo-1,pageSize, Sort.Direction.ASC,"id");

        Page<User> userPage = userRepository.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if (StringUtils.isNotBlank(userQuery.getUsername())){
                    list.add(criteriaBuilder.like(root.get("username").as(String.class),userQuery.getUsername()));
                }
                if (StringUtils.isNotBlank(userQuery.getEmail())){
                    list.add(criteriaBuilder.equal(root.get("email").as(String.class),userQuery.getEmail()));
                }
                Predicate[] predicates = new Predicate[list.size()];

                return criteriaBuilder.and(list.toArray(predicates));
            }
        },pageable);
        return userPage;
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
