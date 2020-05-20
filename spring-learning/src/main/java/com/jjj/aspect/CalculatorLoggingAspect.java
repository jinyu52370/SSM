package com.jjj.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/5 11:34
 *
 * 切面类 通知方法
 *
 */
@Component
@Aspect
public class CalculatorLoggingAspect {
    private Log log = LogFactory.getLog(this.getClass());

    @Pointcut("execution(Double com.jjj.calculator.service.impl.*.*(Double, Double))")
    private void pointcut(){}

    @Before("pointcut()")
    public void logBefore(JoinPoint joinPoint){
        log.info("The method " + joinPoint.getSignature().getName()
            + "() begins with " + Arrays.toString(joinPoint.getArgs())
        );
    }

    @After("pointcut()")
    public void logAfter(JoinPoint joinPoint){
        log.info("The method " + joinPoint.getSignature().getName() + "() ends");
    }

    /**
     * 写返回值时尽量写大些，以覆盖到足够类型的返回值
     */
    @AfterReturning(pointcut = "pointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result){
        log.info("The method " + joinPoint.getSignature().getName() + "() ends with " + result);
    }

    /**
     * 写异常时尽量写大些，以覆盖到足够类型的异常
     * 例：参数表中写入(NullPointerException e)时，若执行div(1, 0)，则此通知方法不会拦截ArithmeticException
     */
    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Exception e){
        log.info("An exception " + e + " has been throwing in " + joinPoint.getSignature().getName() + "()");
    }

    @Around("pointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint){
        //before
        log.info("The method " + joinPoint.getSignature().getName()
                + "() begins with " + Arrays.toString(joinPoint.getArgs())
        );
        Object result = null;
        try {
            result = joinPoint.proceed();
            //afterReturning
            log.info("The method " + joinPoint.getSignature().getName() + "() ends with " + result);
            return result;
        } catch (Throwable e) {
            //afterThrowing
            log.info("An exception " + e + " has been throwing in " + joinPoint.getSignature().getName() + "()");
//            throw new RuntimeException(e);
        } finally {
            //after
            log.info("The method " + joinPoint.getSignature().getName() + "() ends");
        }
        return result;
    }
}
