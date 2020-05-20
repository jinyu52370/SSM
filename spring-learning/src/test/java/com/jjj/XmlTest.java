package com.jjj;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/3 20:49
 */
public class XmlTest {
//    private BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
    private ConfigurableApplicationContext xmlCtx = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void userTest(){
        /*
         * 使用bean的类型获取bean时，xml中必须是唯一的
         * No qualifying bean of type 'User' available: expected single matching bean but found 2: user,user1
         * User user = xmlCtx.getBean(User.class);
         */
        System.out.println(xmlCtx.getBean("user"));

        System.out.println(xmlCtx.getBean("user1"));

        System.out.println(xmlCtx.getBean("user2"));

        System.out.println(xmlCtx.getBean("user3"));
    }

    @Test
    public void userTestSingleton(){
        System.out.println(xmlCtx.getBean("userLifeCycle"));
        xmlCtx.close();
    }

    @Test
    public void userTestPrototype(){
        System.out.println(xmlCtx.getBean("userLifeCyclePrototype"));
        xmlCtx.close();
    }

    @Test
    public void studentTest(){
        System.out.println(xmlCtx.getBean("student"));

        System.out.println(xmlCtx.getBean("student1"));

        System.out.println(xmlCtx.getBean("student2"));
    }

    @Test
    public void airTest() {
        System.out.println(xmlCtx.getBean("air1"));
        System.out.println(xmlCtx.getBean("air1").getClass());

        System.out.println(xmlCtx.getBean("air2"));
        System.out.println(xmlCtx.getBean("air2").getClass());
    }

    @Test
    public void airTest1(){
        Object airFactoryBeanImpl = xmlCtx.getBean("airFactoryBeanImpl");
        System.out.println(airFactoryBeanImpl);
        System.out.println(airFactoryBeanImpl.getClass());
    }

    @Test
    public void beanPostProcessorTest(){
//        xmlCtx.getBean("beanPostProcessorImpl")
    }

    @Test
    public void autowireTest(){
        System.out.println(xmlCtx.getBean("studentAutowire"));
    }
}
