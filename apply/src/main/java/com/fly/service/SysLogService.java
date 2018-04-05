package com.fly.service;

import com.fly.annotation.SysLog;
import com.fly.entity.SysLogEntity;

/**
 * @Author : liufei on 2018/4/3
 */
public interface SysLogService {
    /**
     * save log
     * @param logEntity
     * @return
     */
    SysLogEntity save(SysLogEntity logEntity);
}
