package com.fly.repository;

import com.fly.entity.SysLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author : liufei on 2018/4/3
 */
@Repository
public interface SysLogRepository extends JpaRepository<SysLogEntity,Integer>{
}
