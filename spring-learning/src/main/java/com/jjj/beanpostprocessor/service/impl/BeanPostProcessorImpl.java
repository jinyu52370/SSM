package com.jjj.beanpostprocessor.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/6 22:26
 */
@Component
public class BeanPostProcessorImpl implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(beanName + " 将要调用初始化方法postProcessBeforeInitialization，此bean为：" + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(beanName + " 已调用初始化方法postProcessAfterInitialization，此bean为：" + bean);
        //此处返回值将决定ioc容器中保存的该bean
        return bean;
    }
}
