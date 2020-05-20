package com.jjj;

import com.jjj.service.MulService;
import com.jjj.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/8 18:32
 */
public class TXTest {
    public static void main(String[] args) {
        ApplicationContext xmlCtx = new ClassPathXmlApplicationContext("transaction.xml");
        UserService userService = xmlCtx.getBean(UserService.class);
        MulService mulService = xmlCtx.getBean(MulService.class);

        mulService.mulTx();

//        System.out.println(userService.getClass());

//        System.out.println(userService.queryMoney("jjj1"));

//        new Thread(() -> {
//            try {
//                userService.transfer(50.0, "jjj1", "jjj2");
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        }, "operation1").start();



    }
}
