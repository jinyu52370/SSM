package com.jjj.proxy;

import org.springframework.util.Assert;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/4 22:42
 */
public class CalculatorValidationHandler implements InvocationHandler {
    private Object target;

    public CalculatorValidationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        for (Object arg : args){
            Assert.isTrue((Double)arg > 0, "Positive numbers only");
        }
        return method.invoke(target, args);
    }

    public static Object createProxy(Object target){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new CalculatorValidationHandler(target)
        );
    }
}
