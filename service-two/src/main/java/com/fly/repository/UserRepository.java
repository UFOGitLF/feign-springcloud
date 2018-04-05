package com.fly.repository;

import com.fly.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author : liufei on 2018/3/29
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 修改
     * @param username
     * @param id
     * @return
     */
    @Modifying
    @Query("update User set username = :username where id = :id")
    int update(@Param(value = "username") String username, @Param(value = "id") Integer id);
}
