package com.jjj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @description
 * @date 2019/10/9 21:47
 */
@Component
@Aspect
public class CommonThingsAspect {
    @Pointcut("execution(* com.jjj.mything.service.impl.*.*(..))")
    private void pointcut(){}

    @Before("pointcut()")
    public void qichuang(){
        System.out.println("起床");
    }

    @Before("pointcut()")
    public void chuanyi(){
        System.out.println("穿衣");
    }

    @After("pointcut()")
    public void tuoyi(){
        System.out.println("脱衣");
    }

    @After("pointcut()")
    public void shuijiao(){
        System.out.println("睡觉");
    }

    @Around("pointcut()")
    public void huanrao(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("环绕前1");
        System.out.println("环绕前2");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕后1");
        System.out.println("环绕后2");
    }

    @AfterReturning("pointcut()")
    public void afterReturning(){
        System.out.println("afterReturning");
    }

    @AfterThrowing(value = "pointcut()",throwing = "e")
    public void afterThrowing(Exception e){
        System.out.println("afterThrowing" + e.getMessage());
    }
}
