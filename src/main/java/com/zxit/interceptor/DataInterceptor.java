package com.zxit.interceptor;


import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.zxit.model.MisEmrBasicinfo;
import com.zxit.service.MisEmrBasicinfoService;

//@Component
//@Aspect
public class DataInterceptor {

    @Resource
    private MisEmrBasicinfoService misEmrBasicinfoService;

    //配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
    @Pointcut("execution(* com.zxit.service.impl..MisEmr*.save*(..))")
    public void aspect() {

    }


    //配置后置通知,使用在方法aspect()上注册的切入点
    @Before(value = "aspect()&&args(obj)")
    public void before(JoinPoint joinPoint, MisEmrBasicinfo obj) {
        System.out.println("前obj=" + obj.toString());
    }


    @AfterReturning(value = "aspect()&&args(obj)")
    public void afterReturning(JoinPoint joinPoint, MisEmrBasicinfo obj) {
        System.out.println("后obj=" + obj.toString());
    }


}  