package com.fly.repository;

import com.fly.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author : liufei on 2018/3/29
 */
@Repository
public interface MobileRepository extends JpaRepository<Mobile, Integer> {

}
