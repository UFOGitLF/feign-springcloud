package com.fly.aspect;

import com.alibaba.fastjson.JSON;
import com.fly.annotation.SysLog;
import com.fly.entity.SysLogEntity;
import com.fly.service.SysLogService;
import com.fly.utils.HttpContextUtils;
import com.fly.utils.IpUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author : liufei on 2018/4/3
 */
@Aspect
@Component
public class SysLogAspect {

    @Resource
    private SysLogService sysLogService;

    @Pointcut("@annotation(com.fly.annotation.SysLog)")
    public void pointCut(){

    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long beginTime = System.currentTimeMillis();

        //执行方法
        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        saveLog(joinPoint,endTime-beginTime);

        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        SysLogEntity sysLog = new SysLogEntity();
        SysLog syslog = method.getAnnotation(SysLog.class);
        if(syslog != null){
            //注解上的描述
            sysLog.setOperation(syslog.value());
        }

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");

        //请求的参数
        Object[] args = joinPoint.getArgs();
        try{
            String params = JSON.toJSONString(args[0]);
            sysLog.setParams(params);
        }catch (Exception e){

        }
        //获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        //设置IP地址
        sysLog.setIp(IpUtils.getIpAddr(request));

        //用户名
        sysLog.setUsername("liufly");

        sysLog.setTime(time);

        sysLog.setCreateDate(new Date());
        //保存系统日志
        sysLogService.save(sysLog);
    }

}
