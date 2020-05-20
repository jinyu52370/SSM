package com.jjj;

import config.SpringConfig;
import com.jjj.entity.Student;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/4 10:30
 */
public class AnnotationSpringTest {
    private ConfigurableApplicationContext annotationCtx = new AnnotationConfigApplicationContext(SpringConfig.class);


    @Test
    public void userTest(){
        System.out.println(annotationCtx.getBean("user"));

        /*
         * available: expected single matching bean but found 2: user,user1
         *
         * System.out.println(annotationCtx.getBean(User.class));
         */
    }

    /**
     * 单例：
     *      Bean的生命周期：(容器启动)构造器 -> 初始化方法 -> (容器关闭)销毁方法
     * 多例：
     *      Bean的生命周期：(获取对象)构造器 -> 初始化方法 -> (容器关闭)
     * 后置处理器：
     *      (容器启动)构造器 -> 后置处理器before -> 初始化方法 -> 后置处理器after -> (容器关闭)销毁方法
     *
     *      无论bean是否有初始化方法，后置处理器都会工作
     */
    @Test
    public void userTestSingleton(){
        System.out.println(annotationCtx.getBean("userLifeCycle"));
        annotationCtx.close();
    }

    @Test
    public void userTestPrototype(){
        System.out.println(annotationCtx.getBean("userLifeCyclePrototype"));
        annotationCtx.close();
    }

    @Test
    public void studentTest(){
        System.out.println(annotationCtx.getBean(Student.class));
    }

    @Test
    public void phoneTest() throws Exception {
        System.out.println(annotationCtx.getBean("mi"));
        System.out.println(annotationCtx.getBean("onePlus"));
        System.out.println(annotationCtx.getBean("&mi"));

    }

    @Test
    public void airTest() {
        System.out.println(annotationCtx.getBean("air1"));
        System.out.println(annotationCtx.getBean("air1").getClass());

        System.out.println(annotationCtx.getBean("air2"));
        System.out.println(annotationCtx.getBean("air2").getClass());
    }

    @Test
    public void airTest1(){
        Object airFactoryBeanImpl = annotationCtx.getBean("airFactoryBeanImpl");
        System.out.println(airFactoryBeanImpl);
        System.out.println(airFactoryBeanImpl.getClass());
    }
}
