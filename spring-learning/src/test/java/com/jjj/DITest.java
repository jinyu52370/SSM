package com.jjj;

import com.jjj.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/7 17:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = config.SpringConfig.class)
public class DITest {
    @Autowired
    UserService userService;

    @Test
    public void test(){
        userService.insert();
    }

    @Test
    public void test1(){
        //带泛型的父类类型：com.jjj.service.BaseService<com.jjj.entity.User>
        //spring可以通过带泛型的父类类型来确定子类的类型
        System.out.println(userService.getClass().getGenericSuperclass());
    }
}
