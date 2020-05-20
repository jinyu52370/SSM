package com.jjj.factory;

import com.jjj.entity.Air;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/6 18:24
 *
 * FactoryBean：是spring规定的一个接口，只要实现这个接口，spring都认为实现类是一个工厂
 * spring会自动的调用工厂方法创建生产对象
 * ioc容器启动的时候不会创建实例
 *
 * 无论单例、多实例，均为获取的时候才创建对象
 */
public class AirFactoryBeanImpl implements FactoryBean<Air> {
    @Override
    public Air getObject() throws Exception {
        System.out.println("AirFactoryBeanImpl 调用 getObject()");
        return new Air("factoryBean的机长", "副驾驶", 100.5, 100);
    }

    @Override
    public Class<?> getObjectType() {
        return Air.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
