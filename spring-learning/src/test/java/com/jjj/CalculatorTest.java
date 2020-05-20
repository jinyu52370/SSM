package com.jjj;

import com.jjj.calculator.service.Calculator;
import com.jjj.calculator.service.impl.CalculatorImpl;
import com.jjj.calculator.service.impl.CalculatorNotImpl;
import com.jjj.proxy.CalculatorLoggingHandler;
import com.jjj.proxy.CalculatorProxy;
import com.jjj.proxy.CalculatorValidationHandler;
import config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/4 22:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:applicationContext.xml")
@ContextConfiguration(classes = config.SpringConfig.class)
public class CalculatorTest {
    @Test
    public void proxyTest() throws InterruptedException {
        Calculator calculatorProxy =
                (Calculator) CalculatorValidationHandler.createProxy(
                        CalculatorLoggingHandler.createProxy(new CalculatorImpl()));

        System.out.println(calculatorProxy.add(1.0, 1.0));

        Thread.sleep(500);
        System.out.println("\n**********************\n");

        System.out.println(calculatorProxy.add(-1.0, 1.0));
    }

    @Test
    public void proxyTest1(){
        Calculator calculatorProxy = CalculatorProxy.getProxy(new CalculatorImpl());
        calculatorProxy.div(2.0, 0.0);
    }

    @Test
    public void aopTest1() {
        Calculator calculator = new AnnotationConfigApplicationContext(SpringConfig.class).getBean(Calculator.class);
//        calculator.add(1, 1);
        calculator.div(1.0, 0.0);
    }

    @Test
    public void aopTest2() {
        /*
         * 从IOC容器中得到目标对象，使用接口类型
         * 原因：↓
         */
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Calculator calculator = ctx.getBean(Calculator.class);
        /*
         * 细节1：
         *  CalculatorImpl@2df9b86
         *  class com.sun.proxy.$Proxy30
         *
         *  若通过IOC容器直接获取实现类的对象，会出现NoSuchBeanDefinitionException:
         *  No qualifying bean of type 'CalculatorImpl' available
         *  因为：AOP的底层是动态代理，容器中保存的组件是代理对象：$Proxy30，没有保存实现类的bean，
         *  而代理对象和目标对象的唯一关联：共同的接口
         *  所以需要使用接口得到目标对象
         */
        System.out.println(calculator);
        System.out.println(calculator.getClass());
    }

    @Test
    public void aopTest3() {
        //为没有实现接口的类创建AOP
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        CalculatorNotImpl calculator = ctx.getBean(CalculatorNotImpl.class);

//        calculator.add(1.0, 1.0);

        /*
         * ArithmeticCalculatorNotImpl@53fdffa1
         * class ArithmeticCalculatorNotImpl$$EnhancerBySpringCGLIB$$5c88fff8
         *
         * CGLIB创建了代理对象
         */
        System.out.println(calculator);
        System.out.println(calculator.getClass());
    }

    @Resource
    Calculator calculator;

    @Test
    public void aopTest4(){
        calculator.add(1.0, 1.0);
    }
}
