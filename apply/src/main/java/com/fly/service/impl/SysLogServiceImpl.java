package com.fly.service.impl;

import com.fly.annotation.SysLog;
import com.fly.entity.SysLogEntity;
import com.fly.repository.SysLogRepository;
import com.fly.service.SysLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author : liufei on 2018/4/3
 */
@Service
public class SysLogServiceImpl implements SysLogService{

    @Resource
    private SysLogRepository logRepository;

    @Override
    public SysLogEntity save(SysLogEntity logEntity) {
        return logRepository.save(logEntity);
    }
}
