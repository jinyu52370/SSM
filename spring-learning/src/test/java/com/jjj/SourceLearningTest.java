package com.jjj;

import com.jjj.entity.SourceTest;
import com.jjj.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/8 22:31
 */
public class SourceLearningTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("sourceLearning.xml");
        SourceTest sourceTest = (SourceTest) applicationContext.getBean("sourceTest");
        System.out.println(sourceTest);
    }

}
