package com.jjj.proxy;

import com.jjj.calculator.service.Calculator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/8 9:30
 */
public class CalculatorProxy {
    private static Log log = LogFactory.getLog(CalculatorProxy.class);

    public static Calculator getProxy(Calculator calculator){
        return (Calculator) Proxy.newProxyInstance(
                calculator.getClass().getClassLoader(),
                calculator.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    log.info("The method " + method.getName() + "() begins with " + Arrays.toString(args));
                    Object result = null;
                    try {
                        result = method.invoke(calculator, args);
                    } catch (Exception e) {
                        log.info("The method " + method.getName() + "() throw exception: " + e.getCause());
                    }finally {
                        log.info("The method " + method.getName() + "() ends with " + result);
                    }
                    return result;
                });
    }
}
