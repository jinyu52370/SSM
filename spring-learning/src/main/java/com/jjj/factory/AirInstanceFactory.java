package com.jjj.factory;

import com.jjj.entity.Air;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/6 17:34
 */
public class AirInstanceFactory {
    public Air getAir(String jzName) {
//        System.out.println("调用实例工厂：AirInstanceFactory");
        return new Air(jzName, "副驾驶", 100.5, 100);
    }
}
