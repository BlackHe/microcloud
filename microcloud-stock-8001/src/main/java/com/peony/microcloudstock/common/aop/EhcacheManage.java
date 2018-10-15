package com.peony.microcloudstock.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EhcacheManage {


    /**
     * 切入点
     */
    @Pointcut("@annotation(com.peony.microcloudstock.common.aop.Ehcache)")
    public void simplePointcut(){
    }

    @AfterReturning(pointcut = "simplePointcut()")
    public void simpleAdvice() {
        System.out.println("后置通知......");
    }

    @Before("simplePointcut()")
    public void simleBefore(){
        System.out.println("前置通知.......");
    }
    @Around("simplePointcut()")
    public String beforeAop(ProceedingJoinPoint joinPoint){
        System.out.println("进入---AOP环绕通知切入");
        Object[] args = joinPoint.getArgs();
        Object result = null;
        try {
            result = joinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("退出---AOP环绕通知切入");
        return result == null ?  this.getClass().getName(): result.toString();
    }



}

