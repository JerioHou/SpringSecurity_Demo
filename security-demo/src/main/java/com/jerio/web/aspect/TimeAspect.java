package com.jerio.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Jerio on 2018/1/24.
 */
//@Aspect
//@Component
public class TimeAspect {
    @Around("execution(* com.jerio.web.controller.*.*(..))")
    public Object anyNameisOk(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("time aspect start");
        Object[] args = joinPoint.getArgs();
        for (Object object :args){
            System.out.println("参数 ： "+object);
        }

        long start = new Date().getTime();

        Object object = joinPoint.proceed();

        System.out.println("time aspect 耗时:"+ (new Date().getTime() - start));

        System.out.println("time aspect end");

        return object;
    }
}
